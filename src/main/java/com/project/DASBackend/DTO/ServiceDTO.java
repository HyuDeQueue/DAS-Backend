package com.project.DASBackend.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServiceDTO {
    private Integer serviceId;
    private String serviceName;
    private String serviceDescription;
    private Integer servicePrice;
    private Integer serviceStatus;
}
