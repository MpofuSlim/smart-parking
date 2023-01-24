package com.example.meraki.services.response;

import com.example.meraki.entities.Adverts;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "adverts  payload")
public class CreateAdvertsResponse {

    private Adverts adverts;
}
