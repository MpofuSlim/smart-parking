package com.example.meraki.repositories;

import com.example.meraki.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VouchersRepository extends BaseRepository<Vouchers> {

    //@Query("From Vouchers where batch.active = :active")
    List<Vouchers> findByBatchActive(Boolean active);

    Vouchers findByVoucherCode(String code);

    List<Vouchers> findByOrder(Order order);

    List<Vouchers> findByBatch(Batch batch);

    List<Vouchers> findByBundle(Bundles bundles);

    List<Vouchers> findByBundleAndSold(Bundles bundles, Boolean sold);

    Boolean existsByVoucherCode(String voucherCode);




}
