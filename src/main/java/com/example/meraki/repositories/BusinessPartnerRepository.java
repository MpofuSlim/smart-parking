package com.example.meraki.repositories;

import com.example.meraki.entities.BusinessPartner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessPartnerRepository extends BaseRepository<BusinessPartner>{

    List<BusinessPartner> findByActive(Boolean active);
}
