package com.e451.service;


import com.e451.domain.Product;
import com.e451.models.ProductRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public interface ProductService {

    Page<Product> getProducts(org.springframework.data.domain.Pageable pageable);

}
