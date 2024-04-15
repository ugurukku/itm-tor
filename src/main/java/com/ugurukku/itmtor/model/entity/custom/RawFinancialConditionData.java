package com.ugurukku.itmtor.model.entity.custom;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawFinancialConditionData {
  private String ad;
  private String ksetir;
  private BigDecimal d1;
  private BigDecimal d2;
  private String req;
  private String id;
}
