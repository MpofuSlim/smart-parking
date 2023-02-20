package com.example.meraki;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.annotation.PropertySource;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@PropertySource("classpath:apiUrl.properties")
public class SendRequests {
    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();


    public static CompletableFuture<HttpResponse<String>> payViaTOPG(String token, String inputJson) throws InterruptedException, ExecutionException, JsonProcessingException {

        String authHeader = "Bearer " + token;
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://172.27.34.80:7055/api/Mobilemoney/payEcocash"))
                .header("Content-Type", "application/json")
                .header("Authorization", authHeader)
                .POST(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }



}

