package com.example.meraki;

import lombok.Data;

@Data
public class TestEcocash {
    public String customerMobileNumber;
    public String merchantRef;

    public int amount;
    public String transactionDescription;
}
