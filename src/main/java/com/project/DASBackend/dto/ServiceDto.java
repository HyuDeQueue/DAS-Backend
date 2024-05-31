package com.project.DASBackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServiceDto {
    private Integer serviceId;
    private String serviceName;
    private String serviceDescription;
    private Integer servicePrice;
    private Integer serviceStatus;
}
