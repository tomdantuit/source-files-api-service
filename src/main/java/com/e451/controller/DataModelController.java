package com.e451.controller;

import com.e451.domain.DataModel;
import com.e451.service.DataModelService;
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

import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;

@RestController
public class DataModelController {

    private final DataModelService dataModelService;

    @Autowired
    public DataModelController(DataModelService dataModelService) {

        this.dataModelService = dataModelService;
    }


    @RequestMapping(path = "/dataModel", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<PagedResources<DataModel>> getDataModels(Pageable pageable
            , PagedResourcesAssembler<DataModel> pageResourceAssembler) {

        Page<DataModel> dataModels = dataModelService.getDataModels(pageable);

        return new ResponseEntity(pageResourceAssembler.toResource(dataModels), HttpStatus.OK);
    }
}
