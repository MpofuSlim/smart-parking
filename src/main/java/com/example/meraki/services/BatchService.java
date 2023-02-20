package com.example.meraki.services;

import com.example.meraki.common.createrequests.CreateBatchRequestDTO;
import com.example.meraki.common.createrequests.CreateSellBatchRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBatchRequestDTO;
import com.example.meraki.entities.Batch;
import com.example.meraki.repositories.BatchRepository;
import com.example.meraki.repositories.VouchersRepository;
import com.example.meraki.services.response.CreateBatchResponse;
import com.example.meraki.services.response.CreateSellBatchResponse;
import com.example.meraki.services.response.UpdateBatchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private VouchersRepository vouchersRepository;

    public List<Batch> getBatchById(long id) {
        return batchRepository.findById(id);
    }

    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }


    public List<Batch> getBatchByActive(Boolean active) {
        return batchRepository.findByActive(active);

    }

    public Batch getBatch(Long id) {
        return batchRepository.getReferenceById(id);
    }

    public CreateBatchResponse createBatchId(CreateBatchRequestDTO createBatchRequestDTO) {

        Batch batch = new Batch(

                createBatchRequestDTO.getBatch().getBatchName(),
                false,
                false
        );
        batchRepository.save(batch);
        return new CreateBatchResponse(
                batch

        );

    }


    public CreateSellBatchResponse createBatch(CreateSellBatchRequestDTO createSellBatchRequestDTO) {

        Batch batch = new Batch(

                createSellBatchRequestDTO.getBatch().getBatchName(),
                false,
                false
        );

        batchRepository.save(batch);
        return new CreateSellBatchResponse(
                batch.getId(),

                batch.getActive()
        );

    }

    public UpdateBatchResponse updateBatch(UpdateBatchRequestDTO updateBatchRequestDTO) {

        Batch batch = batchRepository.getReferenceById(updateBatchRequestDTO.getId());
        batch.setBatchName(updateBatchRequestDTO.getBatchName());
        batch.setActive(updateBatchRequestDTO.getActive());
        batch.setSuspended(updateBatchRequestDTO.getSuspended());

        batchRepository.save(batch);

        UpdateBatchResponse updateBatchResponse = new UpdateBatchResponse(
                batch.getBatchName(),
                batch.getActive(),
                batch.getSuspended()
        );

        return updateBatchResponse;
    }


}
