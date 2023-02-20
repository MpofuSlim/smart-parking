package com.example.meraki.controllers;


import com.example.meraki.common.createrequests.CreateBusinessPartnerRolesRequestDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.BusinessPartnerRoles;
import com.example.meraki.services.BusinessPartnerRolesService;
import com.example.meraki.services.response.CreateBusinessPartnerRolesResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BusinessPartnerRolesController {

    @Autowired
    private BusinessPartnerRolesService businessPartnerRolesService;

    @CrossOrigin
    @GetMapping(path = "/businessPartnerRoles/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all business partner roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<BusinessPartnerRoles>> getAllBusinessPartnerRoles(
    ) {
        List<BusinessPartnerRoles> businessPartnerRoles = businessPartnerRolesService.listAllBusinessPartnerRoles();

        return new Response<>(ResponseCode.SUCCESS, "OK", businessPartnerRoles);
    }

    @CrossOrigin
    @PostMapping(path = "/businessPartnerRoles/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Business Partner Roles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<CreateBusinessPartnerRolesResponse> createBusinessPartnerRoles(@RequestBody CreateBusinessPartnerRolesRequestDTO createBusinessPartnerRolesRequestDTO) throws IOException {

        CreateBusinessPartnerRolesResponse createBusinessPartnerRolesResponse = businessPartnerRolesService.createBusinessPartnerRoles(createBusinessPartnerRolesRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Business Partner Role was added.", createBusinessPartnerRolesResponse);
    }

}
