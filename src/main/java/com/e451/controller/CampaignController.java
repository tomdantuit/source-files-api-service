package com.e451.controller;

import com.e451.domain.Campaign;
import com.e451.service.CampaignService;
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
public class CampaignController {


    private CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @RequestMapping(path = "/campaigns", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<PagedResources<Campaign>> getCampaigns(Pageable pageable
            , PagedResourcesAssembler<Campaign> pageResourceAssembler) {
        Page<Campaign> campaigns = campaignService.getCampaigns(pageable);

        return new ResponseEntity(pageResourceAssembler.toResource(campaigns),
                    HttpStatus.OK);
    }
}
