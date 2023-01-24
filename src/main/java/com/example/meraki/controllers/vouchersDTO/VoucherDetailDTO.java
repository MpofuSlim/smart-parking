package com.example.meraki.controllers.vouchersDTO;

import com.example.meraki.controllers.batchDTO.BatchDTO;
import com.example.meraki.controllers.userDTO.UserDTO;
import com.example.meraki.controllers.bundlesDTO.BundlesDTO;
import com.example.meraki.controllers.orderDTO.OrderDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Voucher detailed info")
public class VoucherDetailDTO {

    private VouchersDTO vouchers;

    private UserDTO user;

    private BundlesDTO bundles;

    private BatchDTO batch;

    private OrderDTO order;

}
