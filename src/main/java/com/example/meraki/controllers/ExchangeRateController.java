package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateExchangeRateRequestDTO;
import com.example.meraki.common.updaterequests.UpdateExchangeRateRequestDTO;
import com.example.meraki.controllers.adminPortalUsersDTO.AdminPortalUsersDTO;
import com.example.meraki.controllers.exchangeRateDTO.ExchangeRateDTO;
import com.example.meraki.controllers.exchangeRateDTO.ExchangeRateDetailDTO;
import com.example.meraki.entities.ExchangeRate;
import com.example.meraki.services.AdminPortalUsersService;
import com.example.meraki.services.ExchangeRateService;
import com.example.meraki.services.response.CreateExchangeRateResponse;
import com.example.meraki.services.response.UpdateExchangeRateResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class ExchangeRateController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    AdminPortalUsersService adminPortalUsersService;


    @CrossOrigin
    @PostMapping(path = "/exchangeRate/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "all exchangeRates", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<ExchangeRateDetailDTO> CreateExchangeRate(@RequestBody CreateExchangeRateRequestDTO createExchangeRateRequestDTO) {

        ExchangeRateDetailDTO exchangeRateDetailDTO = null;
        try {
            CreateExchangeRateResponse createExchangeRateResponse = exchangeRateService.createExchangeRate(createExchangeRateRequestDTO);
            exchangeRateDetailDTO = new ExchangeRateDetailDTO(
                    ExchangeRateDTO.fromExchangeRate(createExchangeRateResponse.getExchangeRate()),
                    AdminPortalUsersDTO.fromAdminPortalUsers(adminPortalUsersService.getAdminPortalUser(createExchangeRateRequestDTO.getUserID()))
            );

        } catch (IOException e) {

        }
        return new Response<>(ResponseCode.SUCCESS, "exchange-rate  added.", exchangeRateDetailDTO);
    }

    @CrossOrigin
    @GetMapping(path = "/exchangeRate/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all exchangeRates?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<ExchangeRate>> listExchangeRate() {
        List<ExchangeRate> exchangeRate;

        exchangeRate = exchangeRateService.getAllExchangeRates();

        return new Response<>(ResponseCode.SUCCESS, "OK", exchangeRate);
    }

    @CrossOrigin
    @PutMapping("/exchangeRate/{id}")
    @ApiParam(value = "update  exchangeRate", example = "", required = true)
    public Response<UpdateExchangeRateResponse> updateExchangeRate(
            @RequestBody UpdateExchangeRateRequestDTO updateExchangeRateRequestDTO) {
        UpdateExchangeRateResponse response = exchangeRateService.updateExchangeRate(updateExchangeRateRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


}
