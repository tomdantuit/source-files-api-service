package com.e451.service;


import com.e451.domain.Product;
import com.e451.models.ProductRecord;
import com.e451.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository ProductRepository;

    // Converter used to map a db entity to a domain object
    private static final Converter<ProductRecord, Product> ProductRecordProductConverter
            = new Converter<ProductRecord, Product>() {
        @Override
        public Product convert(ProductRecord productRecord) {

            return new Product(productRecord.getProduct_id(),
                    productRecord.getCommodity_desc(),
                    productRecord.getSub_commodity_desc(),
                    productRecord.getManufacturer(),
                    productRecord.getDepartment(),
                    productRecord.getBrand(),
                    productRecord.getCurr_size_of_product());
        }
    };

    public Converter<ProductRecord, Product> getProductRecordProductConverter() {
        return ProductRecordProductConverter;
    }

    @Autowired
    public ProductServiceImpl(ProductRepository ProductRepository) {
        this.ProductRepository = ProductRepository;
    }

    @Override
    public Page<Product> getProducts(Pageable pageable) {

        Page<ProductRecord> result = ProductRepository.findAll(pageable);

        return result.map(ProductRecordProductConverter);
    }

}
