package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateAdminPortalUsersRolesRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRolesRequestDTO;
import com.example.meraki.entities.AdminPortalUsersRoles;
import com.example.meraki.repositories.AdminPortalUsersRolesRepository;
import com.example.meraki.repositories.RoleRepository;
import com.example.meraki.services.response.CreateAdminPortalUsersRolesResponse;
import com.example.meraki.services.response.UpdateAdminPortalUsersRolesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AdminPortalUsersRolesService {

    @Autowired
    private AdminPortalUsersRolesRepository adminPortalUsersRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    public AdminPortalUsersRolesService(AdminPortalUsersRolesRepository adminPortalUsersRoleRepository) {
        this.adminPortalUsersRoleRepository = adminPortalUsersRoleRepository;
    }

    public List<AdminPortalUsersRoles> getAllAdminPortalUsersRoles() {
        return adminPortalUsersRoleRepository.findAll();
    }

    public CreateAdminPortalUsersRolesResponse createAdminPortalUsersRoles(CreateAdminPortalUsersRolesRequestDTO createAdminPortalUsersRolesRequestDTO) throws IOException {

        AdminPortalUsersRoles adminPortalUsersRoles = new AdminPortalUsersRoles(
                createAdminPortalUsersRolesRequestDTO.getAdminPortalUsersRolesDTO().getName(),
                createAdminPortalUsersRolesRequestDTO.getAdminPortalUsersRolesDTO().getDate_created(),
                false
        );

        adminPortalUsersRoleRepository.save(adminPortalUsersRoles);

        return new CreateAdminPortalUsersRolesResponse(
                adminPortalUsersRoles

        );
    }

    public UpdateAdminPortalUsersRolesResponse updateAdminPortalUsersRoles(UpdateAdminPortalUsersRolesRequestDTO updateAdminPortalUsersRolesRequestDTO) {

        AdminPortalUsersRoles adminPortalUsersRoles = adminPortalUsersRoleRepository.getReferenceById(updateAdminPortalUsersRolesRequestDTO.getId());
        adminPortalUsersRoles.setName(updateAdminPortalUsersRolesRequestDTO.getName());
        adminPortalUsersRoles.setDate_created(updateAdminPortalUsersRolesRequestDTO.getDate_created());
        adminPortalUsersRoles.setActive(updateAdminPortalUsersRolesRequestDTO.getActive());

        adminPortalUsersRoleRepository.save(adminPortalUsersRoles);

        UpdateAdminPortalUsersRolesResponse updateAdminPortalUsersRolesResponse = new UpdateAdminPortalUsersRolesResponse(
                adminPortalUsersRoles.getName(),
                adminPortalUsersRoles.getDate_created(),
                adminPortalUsersRoles.getActive()
        );

        return updateAdminPortalUsersRolesResponse;
    }
}
