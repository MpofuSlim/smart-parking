package com.example.meraki.controllers;

import com.example.meraki.controllers.customerDTO.CustomerPaymentRequestDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.controllers.customerPaymentDTO.CustomerPaymentDTO;
import com.example.meraki.controllers.customerPaymentDTO.CustomerPaymentDetailDTO;
import com.example.meraki.entities.CustomerPayment;
import com.example.meraki.entities.Customers;
import com.example.meraki.services.CustomerPaymentService;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.response.CustomerPaymentResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;


@RestController
@EnableAsync
public class CustomerPaymentController {

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    private Logger logger = LoggerFactory.getLogger(CustomerPaymentController.class);


    private CustomerPaymentService service;

    private CustomersService customerService;




    public CustomerPaymentController (@Autowired CustomerPaymentService service, @Autowired CustomersService customerService) {
        this.service = service;
        this.customerService = customerService;
    }



    @GetMapping(path = "/payments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve all customer payments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<CustomerPayment>> listPayments(
    ) {
        List<CustomerPayment> payments;

        payments = service.getAllCustomerPayments();

        return new Response<>(ResponseCode.SUCCESS, "OK", payments);
    }

    @CrossOrigin
    @GetMapping(path = "/payment/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve By customer Id", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<CustomerPaymentDetailDTO>> getCustomerById(
            @ApiParam(value = "Id of the customer", example = "1", required = true)
            @PathVariable Long customerId) {

        if (service.checkCustomerIdExistsInCustomer(customerId,this.customerService)) {

            return new Response<>(ResponseCode.NOT_FOUND,"No Id in this customer",null);
        }else {
            List<CustomerPayment> customerPaymentsResult = service.getByCustomerId(customerService.getCustomer(customerId));
            List<CustomerPaymentDetailDTO> payload = customerPaymentsResult.stream().map(this::getCustomerPaymentDetail).collect(toList());
            return new Response<>(ResponseCode.SUCCESS, "OK", payload);
        }
    }


    @PostMapping(path ="/payment/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "paynow updates", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CustomerPaymentDetailDTO> processPaynowUpdate(@RequestBody CustomerPaymentRequestDTO requestFromPaynow) {
        logger.info("Payment update received from Paynow: " + requestFromPaynow);

        CustomerPaymentDetailDTO customerPaymentDetailDTO=null;
        try{
            CustomerPaymentResponse customerPaymentResponse = service.MobilePay(requestFromPaynow);
            customerPaymentDetailDTO=new CustomerPaymentDetailDTO(
                    CustomerPaymentDTO.fromCustomerPayment(customerPaymentResponse.getCustomerPayment()),
                    CustomersDTO.fromCustomer(customerService.getCustomer(requestFromPaynow.getCustomerID()))
            );

        }catch (Exception e){
            return new Response<>(ResponseCode.MISSING_INFO, "customer details missing.", null);
        }
        return new Response<>(ResponseCode.SUCCESS, "payment was added.",  customerPaymentDetailDTO);
    }


    private CustomerPaymentDetailDTO getCustomerPaymentDetail(CustomerPayment customerPayment) {
        Customers customers=customerService.getCustomer(customerPayment.getCustomer().getId());

        return new CustomerPaymentDetailDTO(CustomerPaymentDTO.fromCustomerPayment(customerPayment),
                CustomersDTO.fromCustomer(customers)
        );

    }

}
