package com.example.meraki.controllers;

import com.example.meraki.common.createrequests.CreateExchangeRateExpiredRequestDTO;
import com.example.meraki.common.updaterequests.UpdateExchangeRateExpiredRequestDTO;
import com.example.meraki.controllers.userDTO.UserDTO;
import com.example.meraki.controllers.exchangeRateExpiredDTO.ExchangeRateExpiredDTO;
import com.example.meraki.controllers.exchangeRateExpiredDTO.ExchangeRateExpiredDetailDTO;
import com.example.meraki.entities.ExchangeRateExpired;
import com.example.meraki.services.ExchangeRateExpiredService;
import com.example.meraki.services.UserService;
import com.example.meraki.services.response.CreateExchangeRateExpiredResponse;
import com.example.meraki.services.response.UpdateExchangeRateExpiredResponse;
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
public class ExchangeRateExpiredController {
    @Autowired
    private ExchangeRateExpiredService exchangeRateExpiredService;

    @Autowired
    private UserService userService;


    @CrossOrigin
    @PostMapping(path = "/exchange-rate-expired/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Expired exchangeRates", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private Response<ExchangeRateExpiredDetailDTO> CreateExchangeRate(@RequestBody CreateExchangeRateExpiredRequestDTO createExchangeRateExpiredRequestDTO){

        ExchangeRateExpiredDetailDTO exchangeRateExpiredDetailDTO=null;
        try{
            CreateExchangeRateExpiredResponse createExchangeRateExpiredResponse = exchangeRateExpiredService.createExchangeRateExpired(createExchangeRateExpiredRequestDTO);
            exchangeRateExpiredDetailDTO=new ExchangeRateExpiredDetailDTO(
                    ExchangeRateExpiredDTO.fromExchangeRateExpired(createExchangeRateExpiredResponse.getExchangeRateExpired()),
                    UserDTO.fromUser(userService.getUser(createExchangeRateExpiredRequestDTO.getUserID()))
            );

        }catch (IOException e){

        }
        return new Response<>(ResponseCode.SUCCESS, "exchange-rate was added.", exchangeRateExpiredDetailDTO);
    }
    @CrossOrigin
    @GetMapping(path ="/exchange-rate-expired/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "list all exchangeRatesExpired?=true/false", produces = MediaType.APPLICATION_JSON_VALUE)

    public Response<List<ExchangeRateExpired>> listExchangeRateExpiredExpired(){
        List<ExchangeRateExpired> exchangeRateExpired;

        exchangeRateExpired = exchangeRateExpiredService.getAllExchangeRatesExpired();

        return new Response<>(ResponseCode.SUCCESS, "OK", exchangeRateExpired);
    }

    @CrossOrigin
    @PutMapping("/exchangeRateExpired/{id}")
    @ApiParam(value = "update  exchangeRateExpired", example = "", required = true)
    public Response<UpdateExchangeRateExpiredResponse> updateExchangeRateExpired(
            @RequestBody UpdateExchangeRateExpiredRequestDTO updateExchangeRateExpiredRequestDTO) {
        UpdateExchangeRateExpiredResponse response =   exchangeRateExpiredService.updateExchangeRateExpired(updateExchangeRateExpiredRequestDTO);
        return new Response<>(ResponseCode.SUCCESS, "Ok", response);
    }


}
