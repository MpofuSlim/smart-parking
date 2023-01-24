package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateSellBatchRequestDTO;
import com.example.meraki.common.createrequests.CreateSellVoucherRequestDTO;
import com.example.meraki.common.createrequests.CreateVoucherRequestDTO;
import com.example.meraki.common.createrequests.CreateVoucherRequestVerificationDTO;
import com.example.meraki.common.updaterequests.UpdateVoucherByBundleRequestDTO;
import com.example.meraki.common.updaterequests.UpdateVoucherRequestDTO;
import com.example.meraki.controllers.batchDTO.BatchDTO;
import com.example.meraki.controllers.userDTO.UserDTO;
import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import com.example.meraki.controllers.orderDTO.OrderDTO;
import com.example.meraki.controllers.vouchersDTO.*;
import com.example.meraki.entities.*;
import com.example.meraki.repositories.VouchersRepository;
import com.example.meraki.services.*;
import com.example.meraki.services.response.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@AllArgsConstructor
public class VouchersController {
    @Autowired
    private UserService userService;

    @Autowired
    private BundlesService bundlesService;

    @Autowired
    private VouchersService voucherService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @PostMapping(path = "/voucher/sell-batch/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "sellByBatchId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CreateSellBatchResponse> createSellVoucherBatchId(@RequestBody CreateSellBatchRequestDTO createSellBatchRequestDTO) {

        CreateSellBatchResponse createSellBatchResponse = batchService.createBatch(createSellBatchRequestDTO);

        return new Response<>(ResponseCode.SUCCESS, "Batch added.", createSellBatchResponse);

    }

    @Autowired
    private VouchersRepository vouchersRepository;


    @CrossOrigin
    @GetMapping(path = "/voucher/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "batches?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Vouchers>> listVouchersBatch(
    ) {
        List<Vouchers> vouchers;

        vouchers = voucherService.getAllVouchers();

        return new Response<>(ResponseCode.SUCCESS, "OK", vouchers);
    }


    @CrossOrigin
    @GetMapping(path = "/voucher/{batchId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a voucher using  batch Id.", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<VoucherBatchDetailDTO>> getByBatchId(
            @ApiParam(value = "Id of batch", example = "1", required = true)
            @PathVariable Long batchId) {

        if (voucherService.checkVoucherExistsInBatch(batchId, this.batchService)) {
            return new Response<>(ResponseCode.NOT_FOUND, "No batch found", null);
        } else {
            List<Vouchers> voucherResult = voucherService.getVoucherByBatchId(batchService.getBatch(batchId));
            List<VoucherBatchDetailDTO> payload = voucherResult.stream().map(this::getVoucherDetail).collect(toList());
            return new Response<>(ResponseCode.SUCCESS, "OK", payload);
        }
    }

    @CrossOrigin
    @GetMapping(path = "/vouchers/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve a voucher using  order Id.", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<VoucherBatchDetailDTO>> getByOrderId(
            @ApiParam(value = "Id of order", example = "1", required = true)
            @PathVariable Long orderId) {

        if (voucherService.checkVoucherExistsInBatch(orderId, this.batchService)) {
            return new Response<>(ResponseCode.NOT_FOUND, "No order found", null);
        } else {
            List<Vouchers> voucherResult = voucherService.getVouchersByOrderId(orderService.getOrder(orderId));
            List<VoucherBatchDetailDTO> payload = voucherResult.stream().map(this::getVoucherDetail).collect(toList());
            return new Response<>(ResponseCode.SUCCESS, "OK", payload);
        }
    }

    @CrossOrigin
    @PutMapping("/voucher/{id}")
    @ApiParam(value = "update voucher", example = "", required = true)
    public Response<UpdateVoucherResponse> updateVoucherBatchStage(
            @RequestBody UpdateVoucherRequestDTO updateVoucherRequestDTO) {
        UpdateVoucherResponse response = voucherService.updateVoucher(updateVoucherRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


    @CrossOrigin
    @PutMapping(path = "/vouchers///{voucherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update voucher by bundleId.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UpdateVoucherByBundleResponse> updateVoucherByBundleId(
            @ApiParam(value = "bundle", example = "false", required = true) @RequestBody UpdateVoucherByBundleRequestDTO updateVoucherByBundleRequestDTO) {


        UpdateVoucherByBundleResponse response = voucherService.updateVoucherByBundleIdAndSold(updateVoucherByBundleRequestDTO);

        return new Response<>(ResponseCode.SUCCESS, "OK", response);

    }

    @CrossOrigin
    @PutMapping(path = "/vouchers/{voucherId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update vouchers by bundleId.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UpdateVoucherByBundleResponse> updateListVouchersByBundleId(
            @ApiParam(value = "bundle", example = "false", required = true) @RequestBody UpdateVoucherByBundleRequestDTO updateVoucherByBundleRequestDTO) {


        UpdateVoucherByBundleResponse response = voucherService.updateVoucherByBundleIdAndSold(updateVoucherByBundleRequestDTO);

        return new Response<>(ResponseCode.SUCCESS, "OK", response);

    }

   /* @CrossOrigin
    @PutMapping(path = "/vouchers/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update voucher by bundleId.", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Vouchers>> updateVoucherByBundleId( @PathVariable Boolean status)
           {


        List<Vouchers> vouchers = voucherService.setStatusOfBundles(status);

        return new Response<>(ResponseCode.SUCCESS, "OK", vouchers);

    }*/


    @CrossOrigin
    @PostMapping(path = "/voucher/sell-voucher/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "sellVoucherById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<SellVoucherDetailDTO> createSellVoucherByVoucherId(@RequestBody CreateSellVoucherRequestDTO createSellVoucherRequestDTO) {

        SellVoucherDetailDTO sellVoucherDetailDTO = null;
        try {
            CreateSellVoucherResponse createSellVoucherResponse = voucherService.createSellVoucherByVoucherId(createSellVoucherRequestDTO);
            sellVoucherDetailDTO = new SellVoucherDetailDTO(
                    SellVouchersDTO.fromSellVoucher(voucherService.getVoucher(createSellVoucherRequestDTO.getId()))

            );

        } catch (IOException e) {

        }
        return new Response<>(ResponseCode.SUCCESS, "sell-voucher added.", sellVoucherDetailDTO);

    }

    @CrossOrigin
    @PostMapping(path = "/voucher/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "sell-batch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<VoucherDetailDTO> CreateVoucherBatch(@RequestBody CreateVoucherRequestDTO createVoucherRequestDTO) {


        VoucherDetailDTO voucherDetailDTO = null;
        try {
            CreateVoucherResponse createVoucherResponse = voucherService.createVoucherBatch(createVoucherRequestDTO);
            voucherDetailDTO = new VoucherDetailDTO(
                    VouchersDTO.fromVoucher(createVoucherResponse.getVouchers()),
                    UserDTO.fromUser(userService.getUser(createVoucherRequestDTO.getUserID())),
                    BundlesDTO.fromBundles(bundlesService.getBundle(createVoucherRequestDTO.getBundleID())),
                    BatchDTO.fromBatch(batchService.getBatch(createVoucherRequestDTO.getBatchID())),
                    OrderDTO.fromOrder(orderService.getOrder(createVoucherRequestDTO.getOrderId()))


            );

        } catch (IOException e) {

        }
        return new Response<>(ResponseCode.SUCCESS, "Voucher was added.", voucherDetailDTO);
    }

    @CrossOrigin
    @PostMapping(path = "/voucher/verify/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Verify voucher", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CreateVoucherVerificationResponse> verifyCode(
            @ApiParam(value = "verify code")
            @RequestBody CreateVoucherRequestVerificationDTO vouchers) {

        CreateVoucherVerificationResponse payload;


        if (vouchersRepository.existsByVoucherCode(vouchers.getVoucherCode())) {

            payload = voucherService.voucherResponse(vouchers);


            return new Response<>(ResponseCode.SUCCESS, "Voucher verified", payload);


        } else {
            return new Response<>(ResponseCode.NOT_FOUND, "Voucher doesn't exist", null);
        }
    }


    private VoucherBatchDetailDTO getVoucherDetail(Vouchers vouchers) {
        User user = userService.getUser(vouchers.getUser().getId());
        Bundles bundles = bundlesService.getBundle(vouchers.getBundle().getId());
        Batch batch = batchService.getBatch(vouchers.getBatch().getId());
        Order order = orderService.getOrder(vouchers.getOrder().getId());


        return new VoucherBatchDetailDTO(
                VouchersDTO.fromVoucher(vouchers),
                UserDTO.fromUser(user),
                BundlesDTO.fromBundles(bundles),
                BatchDTO.fromBatch(batch),
                OrderDTO.fromOrder(order)
        );

    }
}





























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































