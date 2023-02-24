package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateSellVoucherRequestDTO;
import com.example.meraki.common.createrequests.CreateVoucherRequestDTO;
import com.example.meraki.common.createrequests.CreateVoucherRequestVerificationDTO;
import com.example.meraki.common.updaterequests.UpdateVoucherByBundleRequestDTO;
import com.example.meraki.common.updaterequests.UpdateVoucherRequestDTO;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.*;
import com.example.meraki.services.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Service
public class VouchersService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private VouchersRepository vouchersRepository;
    @Autowired
    private BundlesRepository bundlesRepository;

    @Autowired
    private BundlesCategoryRepository bundlesCategoryRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private OrderRepository orderRepository;
    private final AdminPortalUsersRepository adminPortalUsersRepository;

    public VouchersService(VouchersRepository vouchersRepository,
                           AdminPortalUsersRepository adminPortalUsersRepository) {
        this.vouchersRepository = vouchersRepository;
        this.adminPortalUsersRepository = adminPortalUsersRepository;
    }

    public List<Vouchers> getAllVouchers() {
        return vouchersRepository.findAll();
    }


    public Vouchers getVoucher(Long id) {
        return vouchersRepository.getReferenceById(id);
    }


    public List<Vouchers> getVouchersByOrderId(Order order) {
        return vouchersRepository.findByOrder(order);
    }

    public List<Vouchers> getVouchersByBundleId(Bundles bundles) {
        return vouchersRepository.findByBundle(bundles);
    }

    public List<Vouchers> getVouchersByBundleIdAndSold(Bundles bundles, Boolean sold) {
        return vouchersRepository.findByBundleAndSold(bundles, sold);
    }


    public List<Vouchers> getVoucherByBatchId(Batch batch) {
        return vouchersRepository.findByBatch(batch);
    }


    public CreateVoucherResponse createVoucherBatch(CreateVoucherRequestDTO createVoucherRequestDTO) throws IOException {
        AdminPortalUsers user1 = adminPortalUsersRepository.getReferenceById(createVoucherRequestDTO.getUserID());
        Bundles bundle1 = bundlesRepository.getReferenceById(createVoucherRequestDTO.getBundleID());
        Batch batch1 = batchRepository.getReferenceById(createVoucherRequestDTO.getBatchID());
        Order order1 = orderRepository.getReferenceById(createVoucherRequestDTO.getOrderId());
        Vouchers vouchers = new Vouchers(
                user1,
                bundle1,
                batch1,
                order1,

                createVoucherRequestDTO.getVouchers().getVoucherCode(),
                createVoucherRequestDTO.getVouchers().getEncryptedVoucherCode(),
                createVoucherRequestDTO.getVouchers().getSerialNumber(),
                createVoucherRequestDTO.getVouchers().getApprovedBy(),
                createVoucherRequestDTO.getVouchers().getApproved(),
                createVoucherRequestDTO.getVouchers().getUsed(),
                createVoucherRequestDTO.getVouchers().getIsBlocked(),
                createVoucherRequestDTO.getVouchers().getSold(),
                false
        );

        vouchersRepository.save(vouchers);

        return new CreateVoucherResponse(
                vouchers,
                user1,
                bundle1,
                batch1,
                order1
        );
    }

    public int[] batchUpdate(List<Vouchers> vouchers) {

        return this.jdbcTemplate.batchUpdate(
                "update vouchers set sold = true where id = ?",
                new BatchPreparedStatementSetter() {

                    public void setValues(PreparedStatement ps, int i)
                            throws SQLException {
                        ps.setLong(1, vouchers.get(i).getId());
                    }

                    public int getBatchSize() {
                        return vouchers.size();
                    }

                });

    }

    public List<Vouchers> getVouchersByActiveBatch(Boolean active){
        return vouchersRepository.findByBatchActive(active);
    }
    public CreateSellVoucherResponse createSellVoucherByVoucherId(CreateSellVoucherRequestDTO createSellVoucherRequestDTO) throws IOException {

        Vouchers voucher = vouchersRepository.getReferenceById(createSellVoucherRequestDTO.getId());
        vouchersRepository.save(voucher);

        return new CreateSellVoucherResponse(

                voucher.getId()

        );

    }


    public UpdateVoucherResponse updateVoucher(UpdateVoucherRequestDTO updateVoucherRequestDTO) {

        Vouchers voucher = vouchersRepository.getReferenceById(updateVoucherRequestDTO.getId());
        voucher.setApprovedBy(updateVoucherRequestDTO.getApprovedBy());
        voucher.setApproved(updateVoucherRequestDTO.getApproved());
        voucher.setIsBlocked(updateVoucherRequestDTO.getIsBlocked());

        vouchersRepository.save(voucher);

        UpdateVoucherResponse updateVoucherResponse = new UpdateVoucherResponse(
                voucher.getApprovedBy(),
                voucher.getApproved(),
                voucher.getIsBlocked()
        );

        return updateVoucherResponse;
    }

    public UpdateVoucherByBundleResponse updateVoucherByBundleIdAndSold(UpdateVoucherByBundleRequestDTO updateVoucherByBundleRequestDTO) {

        Vouchers voucher = vouchersRepository.getReferenceById(updateVoucherByBundleRequestDTO.getVoucherId());


        voucher.setId(updateVoucherByBundleRequestDTO.getVoucherId());
        voucher.setSold(updateVoucherByBundleRequestDTO.getSold());

        vouchersRepository.save(voucher);

        UpdateVoucherByBundleResponse updateVoucherByBundleResponse = new UpdateVoucherByBundleResponse(

                voucher.getId(),
                voucher.getSold()

        );

            return updateVoucherByBundleResponse;


    }

    public List<Vouchers> getByActiveBatch (Boolean active){
        return vouchersRepository.findByBatchActive(active);
    }



    public CreateVoucherVerificationResponse voucherResponse(CreateVoucherRequestVerificationDTO verificationRequestDTO) {
        Vouchers vouchers = vouchersRepository.findByVoucherCode(verificationRequestDTO.getVoucherCode());
        return new CreateVoucherVerificationResponse(
                vouchers.getBundle().getGroupPolicyId(),
                vouchers.getBundle().getBundleCategory().getDuration(),
                vouchers.getId()



        );
    }

    public boolean checkVoucherExistsInBatch(Long id, BatchService batchService) {
        boolean result = false;

        try {

            vouchersRepository.findByBatch(batchService.getBatch(id));
        } catch (EntityNotFoundException entityNotFoundException) {
            result = true;
        }
        return result;
    }


}