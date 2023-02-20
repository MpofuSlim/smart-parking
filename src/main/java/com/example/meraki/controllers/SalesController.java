package com.example.meraki.controllers;


import com.example.meraki.entities.Batch;
import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Sales;
import com.example.meraki.entities.Vouchers;
import com.example.meraki.services.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
@AllArgsConstructor
public class SalesController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private BundlesService bundlesService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private VouchersService vouchersService;


    @CrossOrigin
    @GetMapping(path = "/batch{active}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "batches?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Vouchers>> getByBatchActive(
    ) {
        List<Vouchers> vouchers;

        vouchers = vouchersService.getByActiveBatch(true);

        return new Response<>(ResponseCode.SUCCESS, "OK", vouchers);
    }

    @CrossOrigin
    @PostMapping(path = "/sales/{bundleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Sell a  voucher by bundle id.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Stream<Vouchers>> getBatchByActive(

            @ApiParam(value = "bundleId of the voucher", example = "one", required = true)
            @PathVariable Bundles bundleId, Integer quantity) {

        List<Vouchers> vouchersList = vouchersService.getVouchersByBundleIdAndSold(bundleId, false);


        return new Response<>(ResponseCode.SUCCESS, "OK", vouchersList.stream().limit(quantity));

    }


}
