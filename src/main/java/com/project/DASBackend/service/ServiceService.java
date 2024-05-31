package com.project.DASBackend.service;

import com.project.DASBackend.dto.ServiceDto;

import java.util.List;

public interface ServiceService {

//    CreateService
//    etServiceById
//    GetAllServices
//    UpdateService
//    DeleteService

    ServiceDto createService(ServiceDto serviceDto);

    ServiceDto GetServiceById(Integer serviceID);

    List<ServiceDto> GetAllServices();

    ServiceDto UpdateService(Integer serviceId,ServiceDto serviceDto);

    void DeleteService(Integer serviceId);

    void changeStatus(Integer serviceId, Integer status);
}
