package com.example.meraki.common.createrequests;

import com.example.meraki.controllers.batchDTO.BatchDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create sellBatch")
public class CreateSellBatchRequestDTO {
    private BatchDTO batch;



}
