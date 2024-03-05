package com.ugurukku.itmtor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomesDto {

    private String row;
    private BigDecimal column1;
    private BigDecimal column2;
    private BigDecimal column3;
    private BigDecimal column4;
    private BigDecimal column5;

}
