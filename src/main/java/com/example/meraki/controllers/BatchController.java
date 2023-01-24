package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateBatchRequestDTO;
import com.example.meraki.common.updaterequests.UpdateBatchRequestDTO;
import com.example.meraki.entities.Batch;
import com.example.meraki.services.BatchService;
import com.example.meraki.services.VouchersService;
import com.example.meraki.services.response.CreateBatchResponse;
import com.example.meraki.services.response.UpdateBatchResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class BatchController  {
    @Autowired
    private BatchService batchService;

    @Autowired
    private VouchersService voucherService;


    @CrossOrigin
    @PostMapping(path = "/batch/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    private Response<CreateBatchResponse> createBatchId(@RequestBody CreateBatchRequestDTO createBatchRequestDTO) {

        CreateBatchResponse  createBatchResponse = batchService.createBatchId(createBatchRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Batch was added.", createBatchResponse);
    }

    @CrossOrigin
    @GetMapping(path = "/batches/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all batches?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Batch>> listBatches(
    ) {
        List<Batch> batch;

        batch = batchService.getAllBatches();

        return new Response<>(ResponseCode.SUCCESS, "OK", batch);
    }

    @CrossOrigin
    @GetMapping(path = "/batches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a voucher batch by id.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Batch>> getBatchByBatchId(
            @ApiParam(value = "batchId of the voucher", example = "", required = true)
            @PathVariable Long id) {

        List<Batch> batchList = batchService.getBatchById(id);

        return new Response<>(ResponseCode.SUCCESS, "OK", batchList);

    }

    @CrossOrigin
    @GetMapping(path = "/batch/{active}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a  batch by active.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Batch>> getBatchByActive(
            @ApiParam(value = "batch-name of the voucher", example = "true/false", required = true)
            @PathVariable Boolean active) {

        List<Batch> batchList = batchService.getBatchByActive(active);

        return new Response<>(ResponseCode.SUCCESS, "OK", batchList);

    }


    @CrossOrigin
    @PutMapping("/batch/{id}")
    @ApiParam(value = "update batch", example = "", required = true)
    public Response<UpdateBatchResponse> updateBatch(
            @RequestBody UpdateBatchRequestDTO updateBatchRequestDTO) {
        UpdateBatchResponse response =  batchService.updateBatch(updateBatchRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }



}

