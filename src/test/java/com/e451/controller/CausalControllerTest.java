package com.e451.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import com.e451.domain.Causal;
import com.e451.service.CausalService;

import static org.mockito.Mockito.mock;

public class CausalControllerTest {

    private CausalController testCausalController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<Causal>  mockPagedResourcesAssembler = mock(PagedResourcesAssembler.class);
    private CausalService mockCausalService = mock(CausalService.class);

    @Before
    public void setUp() {
        testCausalController = new CausalController(mockCausalService);
    }

    @Test
    public void setTestCausalControllerIsWorking() {
        Assert.assertNotNull("Causal controller failed to start"
            , testCausalController);
    }

    @Test
    public void testCausalControllerReturnsObjects() {
        Assert.assertNotNull("Causal Controller didn't return causal objects",
                testCausalController.getCausals(mockPageable, mockPagedResourcesAssembler));
    }


}
