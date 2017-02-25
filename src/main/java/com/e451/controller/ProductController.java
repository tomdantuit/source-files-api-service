package com.e451.controller;

import com.e451.domain.Product;
import com.e451.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService ProductService) {
        this.productService = ProductService;
    }

    @RequestMapping(path = "/product", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<PagedResources<Product>> getProducts(Pageable pageable
            , PagedResourcesAssembler<Product> pageResourceAssembler) {
        Page<Product> CampaignMemberships = productService.getProducts(pageable);

        return new ResponseEntity(pageResourceAssembler.toResource(CampaignMemberships),
                    HttpStatus.OK);
    }
}
