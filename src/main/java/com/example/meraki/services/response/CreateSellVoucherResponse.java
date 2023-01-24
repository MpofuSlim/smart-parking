package com.example.meraki.services.response;


import com.example.meraki.entities.Vouchers;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateSellVoucherResponse {


    @ApiModelProperty(value = "The name of the batch", required = true, example = "1")
    private Long id;

    public static CreateSellVoucherResponse fromSellVoucher(Vouchers voucher) {

        return new CreateSellVoucherResponse(voucher.getId());
    }

}
