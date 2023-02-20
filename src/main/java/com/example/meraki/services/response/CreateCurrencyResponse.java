
package com.example.meraki.services.response;

import com.example.meraki.entities.AdminPortalUsers;
import com.example.meraki.entities.Currency;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateCurrencyResponse {

    private Currency currency;

    private AdminPortalUsers user;

}



