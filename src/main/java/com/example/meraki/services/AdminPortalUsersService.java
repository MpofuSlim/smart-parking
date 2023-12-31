package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateAdminPortalUsersRequestDTO;
import com.example.meraki.common.misc.AdminLoginRequestDTO;
import com.example.meraki.common.updaterequests.UpdateAdminPortalUsersRequestDTO;
import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.Role;
import com.example.meraki.repositories.AdminPortalUsersRepository;
import com.example.meraki.repositories.RoleRepository;
import com.example.meraki.services.response.AdminLoginResponse;
import com.example.meraki.services.response.CreateAdminPortalUsersResponse;
import com.example.meraki.services.response.UpdateAdminPortalUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPortalUsersService {

    @Autowired
    private AdminPortalUsersRepository adminPortalUsersRepository;
    @Autowired
    private RoleRepository roleRepository;

    public AdminPortalUsersService(AdminPortalUsersRepository adminPortalUsersRepository) {
        this.adminPortalUsersRepository = adminPortalUsersRepository;
    }

    public AdminPortalUsers getAdminPortalUser(Long id) {
        return adminPortalUsersRepository.getReferenceById(id);
    }

    public List<AdminPortalUsers> getAllAdminPortalUsers() {
        return adminPortalUsersRepository.findAll();
    }


    public CreateAdminPortalUsersResponse createAdminPortalUsers(CreateAdminPortalUsersRequestDTO createAdminPortalUsersRequestDTO) {

        Role role1 = roleRepository.getReferenceById(createAdminPortalUsersRequestDTO.getRoleID());
        AdminPortalUsers adminPortalUsers = new AdminPortalUsers(

                role1,
                createAdminPortalUsersRequestDTO.getAdminPortalUsersDTO().getFirstname(),
                createAdminPortalUsersRequestDTO.getAdminPortalUsersDTO().getSurname(),
                createAdminPortalUsersRequestDTO.getAdminPortalUsersDTO().getEmail_address(),
                createAdminPortalUsersRequestDTO.getAdminPortalUsersDTO().getPassword(),

                false
        );

        adminPortalUsersRepository.save(adminPortalUsers);

        return new CreateAdminPortalUsersResponse(
                adminPortalUsers,

                role1
        );
    }

    public UpdateAdminPortalUsersResponse updateAdminPortalUsers(UpdateAdminPortalUsersRequestDTO updateAdminPortalUsersRequestDTO) {

        AdminPortalUsers adminPortalUsers = adminPortalUsersRepository.getReferenceById(updateAdminPortalUsersRequestDTO.getId());
        adminPortalUsers.setFirstname(updateAdminPortalUsersRequestDTO.getFirstname());
        adminPortalUsers.setSurname(updateAdminPortalUsersRequestDTO.getSurname());
        adminPortalUsers.setPassword(updateAdminPortalUsersRequestDTO.getPassword());
        adminPortalUsers.setEmailAddress(updateAdminPortalUsersRequestDTO.getEmailAddress());

        adminPortalUsersRepository.save(adminPortalUsers);

        UpdateAdminPortalUsersResponse updateAdminPortalUsersResponse = new UpdateAdminPortalUsersResponse(
                adminPortalUsers.getFirstname(),
                adminPortalUsers.getSurname(),
                adminPortalUsers.getEmailAddress(),
                adminPortalUsers.getActive()
        );

        return updateAdminPortalUsersResponse;
    }


    public boolean checkAdminExists(AdminLoginRequestDTO adminLoginRequestDTO) {
        AdminPortalUsers admin = adminPortalUsersRepository.findByEmailAddressAndPassword(adminLoginRequestDTO.getEmailAddress(), adminLoginRequestDTO.getPassword());

        if (admin == null) {
            return false;
        } else {
            return true;
        }
    }

    public AdminLoginResponse loginResponse(AdminLoginRequestDTO adminLoginRequestDTO) {
        AdminPortalUsers admin = adminPortalUsersRepository.findByEmailAddressAndPassword(adminLoginRequestDTO.getEmailAddress(), adminLoginRequestDTO.getPassword());
        return new AdminLoginResponse(
                admin.getId(),
                admin.getFirstname(),
                admin.getSurname(),
                admin.getEmailAddress(),
                admin.getRole()
        );
    }

}
