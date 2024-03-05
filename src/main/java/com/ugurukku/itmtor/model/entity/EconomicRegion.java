package com.ugurukku.itmtor.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EconomicRegion {

    private String id;
    private String name;
    private Integer economicRegionId;

}
