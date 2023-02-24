package com.example.meraki.controllers.batchDTO;

import com.example.meraki.entities.Batch;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "bundle")
public class BatchDTO {


    private Long id;

    @ApiModelProperty(value = "", example = "Telone")
    private String batchName;


    public static BatchDTO fromBatch(Batch batch) {

        return new BatchDTO(batch.getId(), batch.getBatchName());
    }

}
