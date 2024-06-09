package com.project.DASBackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicePriceListDto {

    private Integer servicePriceId;

    @NotNull(message = "Service ID cannot be null")
    @Min(value = 0, message = "Service ID must be greater than or equal to 0")
    private Float sizeFrom;

    @NotNull(message = "Service ID cannot be null")
    @Min(value = 0, message = "Service ID must be greater than or equal to 0")
    private Float sizeTo;

    @NotNull(message = "Service ID cannot be null")
    @Min(value = 0, message = "Service ID must be greater than or equal to 0")
    private Integer initPrice;

    @NotNull(message = "Service ID cannot be null")
    @Min(value = 0, message = "Service ID must be greater than or equal to 0")
    private Integer priceUnit;
}
