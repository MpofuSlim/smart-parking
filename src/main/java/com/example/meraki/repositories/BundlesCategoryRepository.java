package com.example.meraki.repositories;

import com.example.meraki.entities.BundleCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BundlesCategoryRepository extends BaseRepository<BundleCategory> {

   List<BundleCategory> findByActive(Boolean active);
}
