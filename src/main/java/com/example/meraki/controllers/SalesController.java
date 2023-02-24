package com.example.meraki.controllers;


import com.example.meraki.entities.Bundles;
import com.example.meraki.entities.Vouchers;
import com.example.meraki.services.BundlesService;
import com.example.meraki.services.OrderService;
import com.example.meraki.services.SalesService;
import com.example.meraki.services.VouchersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @PostMapping(path = "/sales/{bundleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Sell a  voucher by bundle id.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Stream<Vouchers>> sellByBundleId(

            @ApiParam(value = "bundleId of the voucher", example = "one", required = true)
            @PathVariable Bundles bundleId, Boolean sold, Integer quantity)
    {

        List<Vouchers> vouchersList = vouchersService.getVouchersByBundleIdAndSold(bundleId, sold);


        return new Response<>(ResponseCode.SUCCESS, "OK", vouchersList.stream().limit(quantity));

    }

    @CrossOrigin
    @GetMapping(path = "/vouchers/{active}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "retrieve vouchers by active batch.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Vouchers>> getByActiveBatch()

    {

        List<Vouchers> vouchers = vouchersService.getVouchersByActiveBatch(true);


        return new Response<>(ResponseCode.SUCCESS, "OK",vouchers);

    }

    @CrossOrigin
    @PutMapping(path = "/sales/{voucherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update sold status of vouchers.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<int[] > updateBatchToSold(

            @ApiParam(value = "update sold by voucher list", example = "1,2,3", required = true)
            @PathVariable List<Vouchers> voucherId)

    {



        int[] vouchersList = vouchersService.batchUpdate(voucherId);


        return new Response<>(ResponseCode.SUCCESS, "OK", vouchersList);

    }




}
