package com.example.meraki.config.gateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "payment.gateway")
public class PaymentGatewayProperties {
    private String endpointUrl;
    private String notifyUri;
    private String notifyType;
}
