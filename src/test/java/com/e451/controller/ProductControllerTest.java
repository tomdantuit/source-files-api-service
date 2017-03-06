package com.e451.controller;

import com.e451.domain.Product;
import com.e451.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.mockito.Mockito.mock;

public class ProductControllerTest {

    private ProductController testProductController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<Product> mockPagedResourcesAsssembler
            = mock(PagedResourcesAssembler.class);
    private ProductService mockProductService = mock(ProductService.class);


    @Before
    public void setUp() {
        testProductController = new ProductController(mockProductService);
    }

    @Test
    public void testProductControllerShouldConstruct() {
        Assert.assertNotNull("Product controller failed to be initialized"
            , testProductController);
    }

    @Test
    public void testProductControllerShouldReturnAPageOfCampaignMembershipObjects() {

        Assert.assertNotNull("CampaignMembership Controller did not return a page of CampaignMembership objects",
                testProductController.getProducts(mockPageable, mockPagedResourcesAsssembler));

    }
}
