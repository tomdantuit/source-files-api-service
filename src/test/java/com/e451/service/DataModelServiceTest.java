package com.e451.service;

import com.e451.domain.DataModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.mock;

public class DataModelServiceTest {

    private DataModelService testDataModelService;

    @Before
    public void setUp() {
        testDataModelService = new DataModelServiceImpl();
    }

    @Test
    public void testDataModelServiceShouldConstruct() {
        testDataModelService = new DataModelServiceImpl();
        Assert.assertNotNull("DataModelService was not constructed", testDataModelService);
    }

    @Test
    public void testDataModelServiceShouldReturnPageOfDataModels() {
        Pageable pageable = mock(Pageable.class);
        Page<DataModel> dataModels = testDataModelService.getDataModels(pageable);

        Assert.assertNotNull("Result of getDataModels is null", dataModels);
        Assert.assertEquals("No data models returned", 1, dataModels.getTotalElements());
        Assert.assertEquals("Wrong data model id returned"
                , new Long(1)
                , dataModels.getContent().get(0).getId());
        Assert.assertEquals("Data model has the wrong name"
                , "The Complete Journey"
                , dataModels.getContent().get(0).getName());
    }

}
