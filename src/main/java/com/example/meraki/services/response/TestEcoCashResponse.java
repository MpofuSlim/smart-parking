package com.example.meraki.services.response;

import lombok.Data;

@Data
public class TestEcoCashResponse {
    private String ResultCode;
    private String ResultDescription;
    private String EcocashRef;
    private String OrderNumber;
    private String MerchantReference;
}
