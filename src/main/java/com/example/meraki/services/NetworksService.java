package com.example.meraki.services;


import com.example.meraki.common.createrequests.CreateNetworksRequestDTO;
import com.example.meraki.common.updaterequests.UpdateNetworksRequestDTO;
import com.example.meraki.entities.Networks;
import com.example.meraki.entities.Organisations;
import com.example.meraki.entities.User;
import com.example.meraki.repositories.NetworksRepository;
import com.example.meraki.repositories.OrganisationsRepository;
import com.example.meraki.repositories.UserRepository;
import com.example.meraki.services.response.CreateNetworksResponse;
import com.example.meraki.services.response.UpdateNetworksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class NetworksService {
    @Autowired
    private NetworksRepository networksRepository;

    @Autowired
    private OrganisationsRepository organisationsRepository;
    private final AdminPortalUsersRepository adminPortalUsersRepository;


    public NetworksService(NetworksRepository networksRepository,
                           AdminPortalUsersRepository adminPortalUsersRepository){
        this.networksRepository = networksRepository;
        this.adminPortalUsersRepository = adminPortalUsersRepository;
    }

    public List<Networks> getAllNetworks() {
        return networksRepository.findAll();
    }

    @Transactional
    public CreateNetworksResponse createNetworks(CreateNetworksRequestDTO createNetworksRequestDTO) throws IOException {
        AdminPortalUsers user1 = adminPortalUsersRepository.getReferenceById(createNetworksRequestDTO.getUserID());
        Organisations organisations1 = organisationsRepository.getReferenceById(createNetworksRequestDTO.getOrganisationsID());
        Networks networks = new Networks(
                user1,
                organisations1,
                createNetworksRequestDTO.getNetworks().getName(),
                createNetworksRequestDTO.getNetworks().getDate_created(),
                false
        );

        networksRepository.save(networks);

        return new CreateNetworksResponse(
                networks,
                user1,
                organisations1
        );

    }

    public UpdateNetworksResponse updateNetworks(UpdateNetworksRequestDTO updateNetworksRequestDTO) {

        Networks networks = networksRepository.getReferenceById(updateNetworksRequestDTO.getId());
        networks.setName(updateNetworksRequestDTO.getName());
        networks.setActive(updateNetworksRequestDTO.getActive());

        networksRepository.save(networks);

        UpdateNetworksResponse updateNetworksResponse = new UpdateNetworksResponse(
                networks.getName(),
                networks.getActive()
        );

        return  updateNetworksResponse;
    }
}
