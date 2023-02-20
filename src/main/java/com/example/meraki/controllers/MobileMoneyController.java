package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateAuthenticationRequestDTO;
import com.example.meraki.services.BasePriceService;
import com.example.meraki.services.MobileMoneyService;
import com.example.meraki.services.response.CreateAuthenticateResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileMoneyController {

  /*  @Autowired
    MobileMoneyService mobileMoneyService;

    @CrossOrigin
    @PostMapping(path = "/api/Mobilemoney/payEcocash", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Ecocash Payment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)




    private Response<CreateMobileMoneyResponse> mobileMoney(@RequestBody CreateAuthenticationRequestDTO createAuthenticationRequestDTO) {

        CreateMobileMoneyResponse createMobileMoneyResponse = mobileMoneyService.createMobileMoneyResponse(createAuthenticationRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Authentication Successful.", createMobileMoneyResponse);
    }*/
}
