package com.example.meraki.repositories;

import com.example.meraki.entities.Batch;
import com.example.meraki.entities.BusinessPartner;
import com.example.meraki.entities.Order;
import com.example.meraki.entities.Vouchers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order> {

    List<Order> findByBusinessPartner(BusinessPartner businessPartner);
}
