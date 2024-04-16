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
public class RawConsumptionStructureData {
  private String ad;
  private String ksetir;
  private String d1;
  private String d2;
  private String d3;
  private String d4;
}
