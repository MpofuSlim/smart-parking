package com.example.meraki.controllers.vouchersDTO;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "sellVoucher detailed info")
public class SellVoucherDetailDTO {

    private SellVouchersDTO vouchers;



}
