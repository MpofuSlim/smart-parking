package com.example.meraki.controllers.batchDTO;

import com.example.meraki.controllers.vouchersDTO.VouchersDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "batch detailed info")
public class BatchDetailDTO {

    private BatchDTO batch;

    private VouchersDTO voucher;
}
