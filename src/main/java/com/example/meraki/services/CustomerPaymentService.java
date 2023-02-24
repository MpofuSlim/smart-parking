package com.example.meraki.services;


import com.example.meraki.controllers.customerDTO.CustomerPaymentRequestDTO;
import com.example.meraki.entities.CustomerPayment;
import com.example.meraki.entities.Customers;
import com.example.meraki.repositories.CustomerPaymentRepository;
import com.example.meraki.repositories.CustomersRepository;
import com.example.meraki.services.response.CustomerPaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.paynow.constants.MobileMoneyMethod;
import zw.co.paynow.core.Payment;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.MobileInitResponse;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class CustomerPaymentService {
    private Paynow paynow;

    @Autowired
    private CustomerPaymentRepository customerPaymentRepository;

    @Autowired
    private CustomersRepository customersRepository;

    public List<CustomerPayment> getAllCustomerPayments(){
        return customerPaymentRepository.findAll();
    }

    public List<CustomerPayment> getByCustomerId(Customers customer){
        return customerPaymentRepository.findByCustomer(customer);
    }


    public CustomerPaymentService(@Autowired Paynow paynow,CustomerPaymentRepository customerPaymentRepository,CustomersRepository customersRepository) {
        this.paynow = paynow;
        this.customerPaymentRepository = customerPaymentRepository;
        this.customersRepository = customersRepository;
    }


    public boolean checkCustomerIdExistsInCustomer(Long id,CustomersService customersService){
        boolean result=false;

        try {

            customerPaymentRepository.findByCustomer(customersService.getCustomer(id));
        }catch (EntityNotFoundException entityNotFoundException){
            result=true;
        }
        return  result;
    }

    public CustomerPaymentResponse MobilePay(CustomerPaymentRequestDTO customerPaymentDTO) throws IOException {
        Customers customer1 =  customersRepository.getReferenceById(customerPaymentDTO.getCustomerID());
        CustomerPayment customerPayment = new CustomerPayment(
                customer1,
                customerPaymentDTO.getCustomerPayment().getEmail(),
                customerPaymentDTO.getCustomerPayment().getTitle(),
                customerPaymentDTO.getCustomerPayment().getAmount(),
                customerPaymentDTO.getCustomerPayment().getPhone()

        );
        Payment payment = paynow.createPayment(customerPayment.getReference(), customerPaymentDTO.getCustomerPayment().getEmail());


        payment.add(customerPaymentDTO.getCustomerPayment().getTitle(),customerPaymentDTO.getCustomerPayment().getAmount());


        MobileInitResponse response = paynow.sendMobile(payment, customerPaymentDTO.getCustomerPayment().getPhone(), MobileMoneyMethod.ECOCASH);


        //Check if the request was successful
        if (response.success()) {

            //Instructions on how to make the mobile money payment
            String instructions = response.instructions();

            // Get the poll url of the transaction so you can poll the transaction status later if required
            String pollUrl = response.pollUrl();

        }
        else {
            // Something went wrong
            System.out.println(response.errors());
        }

        customerPaymentRepository.save(customerPayment);

        return new CustomerPaymentResponse(
                customerPayment,
                customer1
        );

    }
}
