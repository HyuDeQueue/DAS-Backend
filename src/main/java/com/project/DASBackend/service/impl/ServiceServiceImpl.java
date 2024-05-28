package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.ServiceDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.Services;
import com.project.DASBackend.exception.ResourceNotFoundException;
import com.project.DASBackend.mapper.ServiceMapper;
import com.project.DASBackend.repository.ServiceRepository;
import com.project.DASBackend.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceDto createService(ServiceDto serviceDto) {
        Services services= ServiceMapper.toEntity(serviceDto);
        Services saveService = serviceRepository.save(services);
        return ServiceMapper.toDto((Services) saveService);
    }

    @Override
    public ServiceDto GetServiceById(Integer serviceID) {
        Services service = serviceRepository.findById(serviceID)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Service is not exist with given Id:" + serviceID));
        return ServiceMapper.toDto(service);
    }

    @Override
    public List<ServiceDto> GetAllServices() {
        List<Services> servicesAll=serviceRepository.findAll();
        return servicesAll.stream().map(ServiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDto UpdateService(Integer serviceId, ServiceDto serviceDto) {
        Services services=serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service is not exist with given Id:"+serviceId));
        services.setServiceName(serviceDto.getServiceName());
        services.setServiceDescription(serviceDto.getServiceDescription());
        services.setServiceStatus(serviceDto.getServiceStatus());
        Services saveService = serviceRepository.save(services);
        return ServiceMapper.toDto((Services) saveService);
    }

//    public class ServiceDto {
//        private Integer serviceId;
//        private String serviceName;
//        private String serviceDescription;
//        private Integer servicePrice;
//        private Integer serviceStatus;
//    }


    @Override
    public void DeleteService(Integer serviceId) {
        Services services=serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service is not exist with given Id:"+serviceId));
        serviceRepository.deleteById(serviceId);
    }
}
