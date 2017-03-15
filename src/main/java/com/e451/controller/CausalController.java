package com.e451.controller;


import com.e451.domain.Causal;
import com.e451.service.CausalService;
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
public class CausalController {

    private CausalService causalService;

    @Autowired
    public CausalController(CausalService causalService) {
        this.causalService = causalService;
    }

    @RequestMapping(path="/causals", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<PagedResources<Causal>> getCausals(Pageable pageable
            , PagedResourcesAssembler<Causal> pageResourceAssembler) {
        Page<Causal> causals = causalService.getCausals(pageable);

        return new ResponseEntity(pageResourceAssembler.toResource(causals),
                HttpStatus.OK);
    }
}
