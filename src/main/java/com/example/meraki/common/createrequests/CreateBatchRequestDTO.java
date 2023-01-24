package com.example.meraki.common.createrequests;


import com.example.meraki.controllers.batchDTO.BatchDTO;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "Create Batch")
public class CreateBatchRequestDTO {

    private BatchDTO batch;



}
