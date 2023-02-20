package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateBusinessPartnerRolesRequestDTO;
import com.example.meraki.entities.BusinessPartnerRoles;
import com.example.meraki.repositories.BusinessPartnerRolesRepository;
import com.example.meraki.services.response.CreateBusinessPartnerRolesResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class BusinessPartnerRolesService {
    private final BusinessPartnerRolesRepository businessPartnerRolesRepository;

    public BusinessPartnerRolesService(BusinessPartnerRolesRepository businessPartnerRolesRepository) {
        this.businessPartnerRolesRepository = businessPartnerRolesRepository;
    }

    public List<BusinessPartnerRoles> listAllBusinessPartnerRoles(){
        return businessPartnerRolesRepository.findAll();
    }

    @Transactional
    public CreateBusinessPartnerRolesResponse createBusinessPartnerRoles (CreateBusinessPartnerRolesRequestDTO createBusinessPartnerRolesRequestDTO) throws IOException {
        BusinessPartnerRoles businessPartnerRoles = new BusinessPartnerRoles(
                createBusinessPartnerRolesRequestDTO.getBusinessPartnerRoles().getName(),
                createBusinessPartnerRolesRequestDTO.getBusinessPartnerRoles().getVat(),
                createBusinessPartnerRolesRequestDTO.getBusinessPartnerRoles().getDiscount()

        );

        businessPartnerRolesRepository.save(businessPartnerRoles);

        return new CreateBusinessPartnerRolesResponse(
                businessPartnerRoles
        );
    }
}
