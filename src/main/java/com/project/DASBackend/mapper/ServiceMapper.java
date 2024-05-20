package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.ServiceDto;
import com.project.DASBackend.entity.Service;

public class ServiceMapper {
    public static ServiceDto toDto(Service service) {
        if (service == null) {
            return null;
        }

        ServiceDto dto = new ServiceDto();
        dto.setServiceId(service.getServiceId());
        dto.setServiceDescription(service.getServiceDescription());
        dto.setServiceName(service.getServiceName());
        dto.setServicePrice(service.getServicePrice());
        dto.setServiceStatus(service.getServiceStatus());

        return dto;
    }

    public static Service toEntity(ServiceDto dto) {
        if (dto == null) {
            return null;
        }

        Service service = new Service();
        service.setServiceId(dto.getServiceId());
        service.setServiceDescription(dto.getServiceDescription());
        service.setServiceName(dto.getServiceName());
        service.setServicePrice(dto.getServicePrice());
        service.setServiceStatus(dto.getServiceStatus());

        return service;
    }
}
