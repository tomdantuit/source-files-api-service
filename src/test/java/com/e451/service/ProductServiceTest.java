package com.e451.service;

import com.e451.domain.Product;
import com.e451.models.ProductRecord;
import com.e451.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    // Constants for testing
    private final Long PRODUCT_PRODUCT_ID_1 = new Long(1);
    private final String PRODUCT_COMMODITY_DESC_1= "Commodity1";
    private final String PRODUCT_SUB_COMMODITY_DESC_1= "SubCommodity1";
    private final String PRODUCT_MANUFACTURER_1= "Manufacturer1";
    private final String PRODUCT_DEPARTMENT_1= "Department1";
    private final String PRODUCT_BRAND_1= "Brand1";
    private final String PRODUCT_CURR_SIZE_OF_PRODUCT_1= "SizeOfProduct1";

    private final Long PRODUCT_PRODUCT_ID_2 = new Long(2);
    private final String PRODUCT_COMMODITY_DESC_2= "Commodity2";
    private final String PRODUCT_SUB_COMMODITY_DESC_2= "SubCommodity2";
    private final String PRODUCT_MANUFACTURER_2= "Manufacturer2";
    private final String PRODUCT_DEPARTMENT_2= "Department2";
    private final String PRODUCT_BRAND_2= "Brand2";
    private final String PRODUCT_CURR_SIZE_OF_PRODUCT_2= "SizeOfProduct2";

    private ProductService testProductService;
    private Pageable mockPageable = mock(Pageable.class);
    private ProductRepository ProductRepository = mock(ProductRepository.class);
    private List<ProductRecord> ProductRecords = new ArrayList<>(2);

    @Before
    public void setUp() {
        testProductService = new ProductServiceImpl(ProductRepository);

    }

    @Test
    public void testProductShouldConstruct() {
        Assert.assertNotNull("Product service was not instantiated"
                , testProductService);
    }

    @Test
    public void testProductServiceShouldReturnProducts() {
        ProductRecords.add(new ProductRecord(PRODUCT_PRODUCT_ID_1
        ,PRODUCT_COMMODITY_DESC_1
        ,PRODUCT_SUB_COMMODITY_DESC_1
        ,PRODUCT_MANUFACTURER_1
        ,PRODUCT_DEPARTMENT_1
        ,PRODUCT_BRAND_1
        ,PRODUCT_CURR_SIZE_OF_PRODUCT_1));
        when(ProductRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(ProductRecords));
        Page<Product> Products = testProductService.getProducts(mockPageable);
        Assert.assertNotNull("getProducts returned null", Products);
        Assert.assertNotNull("Product body does not exist"
                , Products.getContent());

    }

    @Test
    public void testProductServiceShouldReturnTwoProducts() {
        ProductRecords.add(new ProductRecord(PRODUCT_PRODUCT_ID_1
                ,PRODUCT_COMMODITY_DESC_1
                ,PRODUCT_SUB_COMMODITY_DESC_1
                ,PRODUCT_MANUFACTURER_1
                ,PRODUCT_DEPARTMENT_1
                ,PRODUCT_BRAND_1
                ,PRODUCT_CURR_SIZE_OF_PRODUCT_1));
        ProductRecords.add(new ProductRecord(PRODUCT_PRODUCT_ID_2
                ,PRODUCT_COMMODITY_DESC_2
                ,PRODUCT_SUB_COMMODITY_DESC_2
                ,PRODUCT_MANUFACTURER_2
                ,PRODUCT_DEPARTMENT_2
                ,PRODUCT_BRAND_2
                ,PRODUCT_CURR_SIZE_OF_PRODUCT_2));
        when(ProductRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(ProductRecords));
        Page<Product> Products = testProductService.getProducts(mockPageable);
        Assert.assertNotNull("getProducts returned null", Products);
        Assert.assertNotNull("Products body does not exist"
                , Products.getContent());
        Assert.assertEquals("not the correct number of Products"
            , 2
            , Products.getContent().size());
    }

    @Test
    public void testProductServiceProductRecordProductConverterProperlyMapsProduct() {
        Converter<ProductRecord, Product> testProductRecordProductConverter
                = testProductService.getProductRecordProductConverter();

        Assert.assertNotNull(testProductRecordProductConverter);

        ProductRecord mockProductRecord = new ProductRecord(PRODUCT_PRODUCT_ID_1
                ,PRODUCT_COMMODITY_DESC_1
                ,PRODUCT_SUB_COMMODITY_DESC_1
                ,PRODUCT_MANUFACTURER_1
                ,PRODUCT_DEPARTMENT_1
                ,PRODUCT_BRAND_1
                ,PRODUCT_CURR_SIZE_OF_PRODUCT_1);

        Product Product = testProductRecordProductConverter.convert(mockProductRecord);

        Assert.assertEquals("The PRODUCT_ID was incorrectly converted"
                , PRODUCT_PRODUCT_ID_1
                , Product.getProduct_id());
        Assert.assertEquals("The COMMODITY_DESC was incorrectly converted"
                , PRODUCT_COMMODITY_DESC_1
                , Product.getCommodity_desc());
        Assert.assertEquals("The SUB_COMMODITY_DESC was incorrectly converted"
                , PRODUCT_SUB_COMMODITY_DESC_1
                , Product.getSub_commodity_desc());
        Assert.assertEquals("The MANUFACTURER was incorrectly converted"
                , PRODUCT_MANUFACTURER_1
                , Product.getManufacturer());
        Assert.assertEquals("The DEPARTMENT was incorrectly converted"
                , PRODUCT_DEPARTMENT_1
                , Product.getDepartment());
        Assert.assertEquals("The BRAND was incorrectly converted"
                , PRODUCT_BRAND_1
                , Product.getBrand());
        Assert.assertEquals("The CURR_SIZE_OF_PRODUCT was incorrectly converted"
                , PRODUCT_CURR_SIZE_OF_PRODUCT_1
                , Product.getCurr_size_of_product());

    }

}
