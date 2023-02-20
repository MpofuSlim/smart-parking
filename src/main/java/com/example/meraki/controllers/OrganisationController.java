package com.example.meraki.controllers;


import com.example.meraki.common.createrequests.CreateOrganisationRequestDTO;
import com.example.meraki.common.updaterequests.UpdateOrganisationsRequestDTO;
import com.example.meraki.controllers.adminPortalUsersDTO.AdminPortalUsersDTO;
import com.example.meraki.controllers.organisationDTO.OrganisationDTO;
import com.example.meraki.controllers.organisationDTO.OrganisationDetailDTO;
import com.example.meraki.entities.Organisations;
import com.example.meraki.services.AdminPortalUsersService;
import com.example.meraki.services.OrganisationService;
import com.example.meraki.services.response.CreateOrganisationResponse;
import com.example.meraki.services.response.UpdateOrganisationsResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;

    @Autowired
    AdminPortalUsersService adminPortalUsersService;

    @CrossOrigin
    @GetMapping(path = "/organisations/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all organisations", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Organisations>> listAllOrganisations(
    ) {
        List<Organisations> organisations;

        organisations = organisationService.getAllOrganisations();

        return new Response<>(ResponseCode.SUCCESS, "OK", organisations);
    }

    @CrossOrigin
    @PostMapping(path = "/organisations/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all organisations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<OrganisationDetailDTO> CreateOrganisation(@RequestBody CreateOrganisationRequestDTO createOrganisationRequestDTO) {

        OrganisationDetailDTO organisationDetailDTO = null;
        try {
            CreateOrganisationResponse createOrganisationResponse = organisationService.createOrganisation(createOrganisationRequestDTO);
            organisationDetailDTO = new OrganisationDetailDTO(
                    OrganisationDTO.fromOrganisations(createOrganisationResponse.getOrganisation()),
                    AdminPortalUsersDTO.fromAdminPortalUsers(adminPortalUsersService.getAdminPortalUser(createOrganisationRequestDTO.getUserID()))
            );

        } catch (IOException e) {

        }
        return new Response<>(ResponseCode.SUCCESS, "organisation added.", organisationDetailDTO);
    }

    @CrossOrigin
    @PutMapping("/organisations/{id}")
    @ApiParam(value = "update organisations", example = "", required = true)
    public Response<UpdateOrganisationsResponse> updateOrganisations(
            @RequestBody UpdateOrganisationsRequestDTO updateOrganisationsRequestDTO) {
        UpdateOrganisationsResponse response = organisationService.updateOrganisations(updateOrganisationsRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


}
