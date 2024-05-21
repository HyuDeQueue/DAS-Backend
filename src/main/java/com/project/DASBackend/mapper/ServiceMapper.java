package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.ServiceDto;
import com.project.DASBackend.entity.Service;

public class ServiceMapper {
    public static ServiceDto toDto(Service service) {
        if (service == null) {
            return null;
        }
        return new ServiceDto(
                service.getServiceId(),
                service.getServiceName(),
                service.getServiceDescription(),
                service.getServicePrice(),
                service.getServiceStatus()
        );
    }

    public static Service toEntity(ServiceDto serviceDto) {
        if (serviceDto == null) {
            return null;
        }
        Service service = new Service();
        service.setServiceId(serviceDto.getServiceId());
        service.setServiceName(serviceDto.getServiceName());
        service.setServiceDescription(serviceDto.getServiceDescription());
        service.setServicePrice(serviceDto.getServicePrice());
        service.setServiceStatus(serviceDto.getServiceStatus());
        return service;
    }
}
