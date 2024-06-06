package com.project.DASBackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServiceDto {

    @NotNull(message = "Service ID cannot be null")
    @Min(value = 0, message = "Service ID must be greater than or equal to 0")
    private Integer serviceId;

    @NotBlank(message = "Service name cannot be blank")
    private String serviceName;

    @NotBlank(message = "Service description cannot be blank")
    private String serviceDescription;

    @NotNull(message = "Service price cannot be null")
    private Integer servicePrice;

    @NotNull(message = "Service status cannot be null")
    private Integer serviceStatus;
}
