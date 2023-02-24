package com.example.meraki.services;

import com.example.meraki.SendRequests;
import com.example.meraki.TestEcocash;
import com.example.meraki.services.response.TestEcoCashResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ShopTransactionService {

    public ResponseEntity<?> testAuth(String token) {
        try {// For login replace TestECocash with Login Object
            TestEcocash ecocash = new TestEcocash();
            ecocash.setAmount(1);
            ecocash.setCustomerMobileNumber("0782606983");
            ecocash.setMerchantRef("myRef123");
            ecocash.setTransactionDescription("Test payment");


            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            String endpoint = "";
            String json = mapper.writeValueAsString(ecocash);
            CompletableFuture<HttpResponse<String>> response = SendRequests.payViaTOPG(token, json);

            ObjectMapper mapper1 = new ObjectMapper();
            mapper1.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            //For login replace TestEcoCashResponse with Login Response Class

            TestEcoCashResponse testEcoCashResponse = mapper1.readValue(response.get().body(), TestEcoCashResponse.class);
            return ResponseEntity.ok(testEcoCashResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Failed to process");
    }



}


