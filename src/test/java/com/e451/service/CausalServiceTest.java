package com.e451.service;


import com.e451.domain.Causal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.mock;

public class CausalServiceTest {

    private CausalService testCausalService;
    private Pageable mockPageable = mock(Pageable.class);

    @Before
    public void setUp() {
        testCausalService = new CausalServiceImpl();
    }

    @Test
    public void setTestCausalServiceShouldConstruct() {
       Assert.assertNotNull("Causal service didn't start"
            , testCausalService);
    }

    @Test
    public void setTestCausalServiceShouldReturnCausals() {
        Page<Causal> causals = testCausalService.getCausals(mockPageable);
        Assert.assertNotNull("getCausals returned null", causals);
        Assert.assertNotNull("causals body does not exist"
            , causals.getContent());
    }
}
