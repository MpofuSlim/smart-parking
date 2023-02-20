package com.example.meraki.controllers;


import com.example.meraki.common.createrequests.CreateAuthenticationRequestDTO;
import com.example.meraki.entities.Authenticate;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.util.Arrays;

@RestController
public class AuthenticateController {


    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Authentication", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    private Response<Authenticate> authenticate(@RequestBody Authenticate authenticate) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("http://172.27.34.80:7055/api/Authenticate/login");


        try {
            authenticate.setPassword("InnoEco@15022023#");
            authenticate.setUsername("InnovationEcocash");
            CreateAuthenticationRequestDTO createdAuthentication = restTemplate.postForObject(uri, authenticate, CreateAuthenticationRequestDTO.class);


            return new Response<>(ResponseCode.SUCCESS, "successful", authenticate);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
        return new Response<>(ResponseCode.NOT_FOUND, "wrong credentials", null);


    }


        /*RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("http://172.27.34.80:7055/api/Authenticate/login");

        try {
            authenticate.setPassword("InnoEco@15022023#");
            authenticate.setUsername("InnovationEcocash");
          //  CreateAuthenticationRequestDTO createdAuthentication = restTemplate.postForObject(uri, authenticate, CreateAuthenticationRequestDTO.class);
            ResponseEntity<Authenticate> response = restTemplate.exchange(uri, HttpMethod.POST, , CreateAuthenticationRequestDTO.class);
            Authenticate responseBody = response.getBody();
            return new Response<>(ResponseCode.SUCCESS, "successful", responseBody);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
        return new Response<>(ResponseCode.NOT_FOUND, "Wrong credentials", null);
    }*/


}


