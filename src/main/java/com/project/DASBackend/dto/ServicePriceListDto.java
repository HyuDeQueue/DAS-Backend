package com.project.DASBackend.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicePriceListDto {
    private Integer servicePriceId;
    private Float sizeFrom;
    private Float sizeTo;
    private Integer initPrice;
    private Integer priceUnit;
}
