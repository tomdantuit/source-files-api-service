package com.e451.controller;

import com.e451.domain.CampaignDescription;
import com.e451.service.CampaignDescriptionService;
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
public class CampaignDescriptionController {


    private CampaignDescriptionService campaignDescriptionService;

    @Autowired
    public CampaignDescriptionController(CampaignDescriptionService CampaignDescriptionService) {
        this.campaignDescriptionService = CampaignDescriptionService;
    }

    @RequestMapping(path = "/CampaignDescriptions", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<PagedResources<CampaignDescription>> getCampaignDescriptions(Pageable pageable
            , PagedResourcesAssembler<CampaignDescription> pageResourceAssembler) {
        Page<CampaignDescription> CampaignDescriptions = campaignDescriptionService.getCampaignDescriptions(pageable);

        return new ResponseEntity(pageResourceAssembler.toResource(CampaignDescriptions),
                    HttpStatus.OK);
    }
}
