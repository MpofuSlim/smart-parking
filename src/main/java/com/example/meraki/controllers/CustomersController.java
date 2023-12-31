package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateCustomerRequestDTO;
import com.example.meraki.common.misc.CustomerLoginRequestDTO;
import com.example.meraki.common.updaterequests.UpdateCustomersRequestDTO;
import com.example.meraki.controllers.customerDTO.CustomerDetailDTO;
import com.example.meraki.controllers.customerDTO.CustomersDTO;
import com.example.meraki.entities.Customers;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.services.CustomersService;
import com.example.meraki.services.response.CreateCustomerResponse;
import com.example.meraki.services.response.CustomerLoginResponse;
import com.example.meraki.services.response.UpdateCustomersResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomersController {
    @Autowired
    private CustomersService customerService;

    @Autowired
    private CustomersRepository customersRepository;


    @CrossOrigin
    @GetMapping(path = "/customer/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all customers?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<Customers>> listCustomers() {
        List<Customers> customers;

        customers = customerService.getAllCustomers();

        return new Response<>(ResponseCode.SUCCESS, "OK", customers);
    }


    @CrossOrigin
    @PostMapping(path = "/customer/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all customers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CustomerDetailDTO> CreateVoucherBatch(@RequestBody CreateCustomerRequestDTO createCustomerRequestDTO) {

        CustomerDetailDTO customerDetailDTO = null;
        if (customersRepository.existsByEmail(createCustomerRequestDTO.getCustomers().getEmail())) {

            return new Response<>(ResponseCode.DUPLICATE, "email already exists.", null);
        }
            CreateCustomerResponse createCustomerResponse = customerService.createCustomer(createCustomerRequestDTO);
            customerDetailDTO = new CustomerDetailDTO(
                    CustomersDTO.fromCustomer(createCustomerResponse.getCustomers())
            );


        return new Response<>(ResponseCode.SUCCESS, "customer added successfully.", customerDetailDTO);
    }






    @CrossOrigin
    @PostMapping(path = "/customer/login/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Verify customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CustomerLoginResponse> listUsers(
            @ApiParam(value = "login customer")
            @RequestBody CustomerLoginRequestDTO customerLoginRequestDTO) {
        CustomerLoginResponse customerLoginResponse;

        if (customerService.checkUserExists(customerLoginRequestDTO)) {
            customerLoginResponse = customerService.loginResponse(customerLoginRequestDTO);
            return new Response<>(ResponseCode.SUCCESS,
                    "OK", customerLoginResponse
            );
        } else {
            return new Response<>(ResponseCode.NOT_FOUND,
                    "Incorrect username or password", null
            );
        }
    }

    @CrossOrigin
    @PutMapping("/customers/{id}")
    @ApiParam(value = "update  customers", example = "", required = true)
    public Response<UpdateCustomersResponse> updateCustomers(
            @RequestBody UpdateCustomersRequestDTO updateCustomersRequestDTO) {
        UpdateCustomersResponse response = customerService.updateCustomers(updateCustomersRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }
}
