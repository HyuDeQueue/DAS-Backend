package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.ServiceDto;
import com.project.DASBackend.entity.Services;
import com.project.DASBackend.entity.Services;

public class ServiceMapper {
    public static ServiceDto toDto(Services service) {
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

    public static Services toEntity(ServiceDto serviceDto) {
        if (serviceDto == null) {
            return null;
        }
        Services service = new Services();
        service.setServiceId(serviceDto.getServiceId());
        service.setServiceName(serviceDto.getServiceName());
        service.setServiceDescription(serviceDto.getServiceDescription());
        service.setServicePrice(serviceDto.getServicePrice());
        service.setServiceStatus(serviceDto.getServiceStatus());
        return service;
    }
}
