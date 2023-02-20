package com.example.meraki.repositories;


import com.example.meraki.entities.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends BaseRepository<Currency>{

    List<Currency> findByActive(Boolean active);



}
