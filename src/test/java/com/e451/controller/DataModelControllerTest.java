package com.e451.controller;


import com.e451.domain.DataModel;
import com.e451.service.DataModelService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataModelControllerTest {

    DataModelController testDataModelController = null;

    Pageable mockPageable = mock(Pageable.class);
    PagedResourcesAssembler<DataModel> mockPageResourceAssembler = mock(PagedResourcesAssembler.class);
    List<DataModel> mockDataModels = new ArrayList<>(1);
    DataModelService mockDataModelService = mock(DataModelService.class);

    @Before
    public void setUp() {
        mockDataModels.add(new DataModel(new Long(1), "The Complete Journey"));
        testDataModelController = new DataModelController(mockDataModelService);
    }

    @Test
    public void testDataModelControllerShouldConstruct() {
        testDataModelController = new DataModelController(mockDataModelService);
        Assert.assertNotNull(testDataModelController);
    }

    @Test
    public void testDataModelControllerGetDataModelsShouldReturnAPageOfDataModelsWithTheirIds() {

        PagedResources.PageMetadata mockMetadata = mock(PagedResources.PageMetadata.class);
        when(mockMetadata.getNumber()).thenReturn(new Long(1));
        PagedResources<DataModel> testPagedDataModel = new PagedResources<>(mockDataModels
                , mockMetadata);
        when(mockPageResourceAssembler.toResource(any(Page.class))).thenReturn(testPagedDataModel);
        when(mockDataModelService.getDataModels(any(Pageable.class))).thenReturn(mock(Page.class));

        HttpEntity<PagedResources<DataModel>> dataModels
                = testDataModelController.getDataModels(mockPageable, mockPageResourceAssembler);

        Assert.assertNotNull(dataModels);
        Assert.assertNotNull(dataModels.getBody());
        Assert.assertNotNull(dataModels.getBody().getMetadata());
        Assert.assertNotEquals("There are no items being returned"
                , 0
                , dataModels.getBody().getMetadata().getNumber());

    }
}
