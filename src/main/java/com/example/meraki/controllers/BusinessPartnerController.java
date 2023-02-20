package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateBusinessPartnerRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBusinessPartnerRequestDTO;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.services.BusinessPartnerService;
import com.example.meraki.services.response.CreateBusinessPartnerResponse;
import com.example.meraki.services.response.UpdateBusinessPartnerResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusinessPartnerController {
    @Autowired
    private BusinessPartnerService businessPartnerService;

    @CrossOrigin
    @GetMapping(path = "/businessPartners/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all business_partners?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<BusinessPartner>> listBusinessPartners(   ) {
        List<BusinessPartner> businessPartners;

        businessPartners = businessPartnerService.getAllBusinessPartrners();

        return new Response<>(ResponseCode.SUCCESS, "OK", businessPartners);
    }

    @CrossOrigin
    @GetMapping(path = "/businessPartner/{active}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve business partners by active.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<BusinessPartner>> getBusinessPartnerByActive(
            @ApiParam(value = "business partners", example = "false", required = true)
            @PathVariable Boolean active) {

        List<BusinessPartner> activeList = businessPartnerService.getBusinessPartnerByActive(active);

        return new Response<>(ResponseCode.SUCCESS, "OK", activeList);

    }

    @CrossOrigin
    @PostMapping(path = "/business_partner/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create business partner ", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CreateBusinessPartnerResponse> createBusinessPartner(
            @ApiParam(required = true) @RequestBody CreateBusinessPartnerRequestDTO createBusinessPartnerRequestDTO) {

        CreateBusinessPartnerResponse createBusinessPartnerResponse=businessPartnerService.CreateBusinessPartner(createBusinessPartnerRequestDTO);

        return new Response<>(ResponseCode.SUCCESS, "Ok", createBusinessPartnerResponse);

    }

    @CrossOrigin
    @PutMapping("/businessPartner/{id}")
    @ApiParam(value = "update  businessPartner", example = "", required = true)
    public Response<UpdateBusinessPartnerResponse> updateBundle(
            @RequestBody UpdateBusinessPartnerRequestDTO updateBusinessPartnerRequestDTO) {
        UpdateBusinessPartnerResponse response =  businessPartnerService.updateBusinessPartner(updateBusinessPartnerRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }
}
