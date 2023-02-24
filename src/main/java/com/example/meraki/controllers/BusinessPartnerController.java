package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateBusinessPartnerRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBusinessPartnerRequestDTO;
import com.example.meraki.controllers.businessPartnerDTO.BusinessPartnerDTO;
import com.example.meraki.controllers.businessPartnerDTO.BusinessPartnerDetailsDTO;
import com.example.meraki.controllers.businessPartnerRolesDTO.BusinessPartnerRolesDTO;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.services.BusinessPartnerRolesService;
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

    @Autowired
    private BusinessPartnerRolesService businessPartnerRolesService;

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
    @ApiOperation(value = "create business partner", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<BusinessPartnerDetailsDTO> createBusinessPartner(@RequestBody CreateBusinessPartnerRequestDTO createBusinessPartnerRequestDTO) {

        BusinessPartnerDetailsDTO businessPartnerDetailDTO = null;

            CreateBusinessPartnerResponse createBusinessPartnerResponse = businessPartnerService.CreateBusinessPartner(createBusinessPartnerRequestDTO);
            businessPartnerDetailDTO = new BusinessPartnerDetailsDTO(
                    BusinessPartnerDTO.fromBusinessPartner(createBusinessPartnerResponse.getBusinessPartner()),
                    BusinessPartnerRolesDTO.fromBusinessPartnerRoles(businessPartnerRolesService.getBusinessPartnerRoles(createBusinessPartnerRequestDTO.getBusinessPartnerRolesID()))
            );


        return new Response<>(ResponseCode.SUCCESS, "business partner was added.", businessPartnerDetailDTO);
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
