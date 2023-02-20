package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateOrganisationRequestDTO;
import com.example.meraki.common.updaterequests.UpdateOrganisationsRequestDTO;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.AdminPortalUsersRepository;
import com.example.meraki.repositories.OrganisationsRepository;
import com.example.meraki.services.response.CreateOrganisationResponse;
import com.example.meraki.services.response.UpdateOrganisationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OrganisationService {
    @Autowired
    private OrganisationsRepository organisationsRepository;

    private final AdminPortalUsersRepository adminPortalUsersRepository;

    public OrganisationService(OrganisationsRepository organisationsRepository,
                               AdminPortalUsersRepository adminPortalUsersRepository){
        this.organisationsRepository = organisationsRepository;
        this.adminPortalUsersRepository = adminPortalUsersRepository;
    }

    public Organisations getOrganisation(Long id) {
        return organisationsRepository.getReferenceById(id);
    }

    public List<Organisations> getAllOrganisations() {
        return organisationsRepository.findAll();
    }

    public CreateOrganisationResponse createOrganisation(CreateOrganisationRequestDTO createOrganisationRequestDTO) throws IOException {
        AdminPortalUsers user1 = adminPortalUsersRepository.getReferenceById(createOrganisationRequestDTO.getUserID());
        Organisations organisations = new Organisations(
                user1,
                createOrganisationRequestDTO.getOrganisation().getName(),
                createOrganisationRequestDTO.getOrganisation().getDate_created(),
                false
        );

        organisationsRepository.save(organisations);

        return new CreateOrganisationResponse(
                organisations,
                user1
        );
    }

    public UpdateOrganisationsResponse updateOrganisations(UpdateOrganisationsRequestDTO updateOrganisationsRequestDTO) {

        Organisations organisations = organisationsRepository.getReferenceById(updateOrganisationsRequestDTO.getId());
        organisations.setName(updateOrganisationsRequestDTO.getName());
        organisations.setActive(updateOrganisationsRequestDTO.getActive());

        organisationsRepository.save(organisations);

        UpdateOrganisationsResponse updateOrganisationsResponse = new UpdateOrganisationsResponse(
                organisations.getName(),
                organisations.getActive()
        );

        return  updateOrganisationsResponse;
    }
}
