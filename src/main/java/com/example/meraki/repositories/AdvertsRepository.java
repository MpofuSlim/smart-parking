package com.example.meraki.repositories;

import com.example.meraki.entities.Adverts;
import com.example.meraki.entities.BundleCategory;
import com.example.meraki.entities.Bundles;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertsRepository extends BaseRepository<Adverts>{

    List<Adverts> findByid(Long id);

    List<Adverts> findByActive(Boolean active, Sort sort);
}
