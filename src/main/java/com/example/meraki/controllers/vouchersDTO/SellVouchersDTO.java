package com.example.meraki.controllers.vouchersDTO;

import com.example.meraki.entities.Vouchers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "voucher")
public class SellVouchersDTO {


    @ApiModelProperty(value = "voucherCode", required = true, example = "12345678")
    private String voucherCode;

    @ApiModelProperty(value = "voucher encryptedVoucherCode", required = true, example = "sbfshgfbhshsbfhsdfgfsah")
    private String encryptedVoucherCode;

    @ApiModelProperty(value = "voucher serialNumber", required = true, example = "12345")
    private Integer serialNumber;

    @ApiModelProperty(value = "voucher ApprovedBy", required = true, example = "1")
    private Integer approvedBy;

    @ApiModelProperty(value = "approved voucher", required = true, example = "1")
    private Integer approved;

    @ApiModelProperty(value = "used voucher", required = true, example = "false")
    private Boolean used;

    @ApiModelProperty(value = "voucher state", required = true, example = "false")
    private Boolean isBlocked;

    @ApiModelProperty(value = "", required = true, example = "false")
    private Boolean active;

    public static SellVouchersDTO fromSellVoucher(Vouchers vouchers) {
        return new SellVouchersDTO(vouchers.getVoucherCode(), vouchers.getEncryptedVoucherCode(), vouchers.getSerialNumber(), vouchers.getApprovedBy(), vouchers.getApproved(), vouchers.getUsed(), vouchers.getIsBlocked(), vouchers.getActive());
    }
}
