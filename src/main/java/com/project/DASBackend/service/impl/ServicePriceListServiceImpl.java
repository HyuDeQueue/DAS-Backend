package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.ServicePriceListDto;
import com.project.DASBackend.entity.ServicePriceList;
import com.project.DASBackend.entity.Services;
import com.project.DASBackend.mapper.ServicePriceListMapper;
import com.project.DASBackend.repository.ServicePriceListRepository;
import com.project.DASBackend.repository.ServiceRepository;
import com.project.DASBackend.service.ServicePriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServicePriceListServiceImpl implements ServicePriceListService {

    @Autowired
    private ServiceRepository serviceRepository;
    private ServicePriceListRepository servicePriceListRepository;
    @Override
    public ServicePriceListDto createServicePriceList(ServicePriceListDto servicePriceListDto) {
        Services services = serviceRepository.findById(servicePriceListDto.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service is not exist with given Id:" + servicePriceListDto.getServiceId()));
        ServicePriceList servicePriceList = ServicePriceListMapper.toEntity(servicePriceListDto, services);
        ServicePriceList saveServicePriceList = servicePriceListRepository.save(servicePriceList);
        return ServicePriceListMapper.toDto(saveServicePriceList);
    }

    @Override
    public ServicePriceListDto getServicePriceListById(Integer servicePriceListId) {
        ServicePriceList servicePriceList = servicePriceListRepository.findById(servicePriceListId)
                .orElseThrow(() -> new RuntimeException("Service price list is not exist with given Id:" + servicePriceListId));
        return ServicePriceListMapper.toDto(servicePriceList);
    }

    @Override
    public List<ServicePriceListDto> getAllServicePriceList() {
        List<ServicePriceList> servicePriceLists = servicePriceListRepository.findAll();
        return servicePriceLists.stream().map(ServicePriceListMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ServicePriceListDto updateServicePriceList(Integer servicePriceListId, ServicePriceListDto updatedServicePriceListDto) {
        ServicePriceList servicePriceList = servicePriceListRepository.findById(servicePriceListId)
                .orElseThrow(() -> new RuntimeException("Service price list is not exist with given Id:" + servicePriceListId));
        if(updatedServicePriceListDto.getServiceId() != null){
            Services services = serviceRepository.findById(updatedServicePriceListDto.getServiceId())
                    .orElseThrow(() -> new RuntimeException("Service is not exist with given Id:" + updatedServicePriceListDto.getServiceId()));
            servicePriceList.setService(services);
        }
        servicePriceList.setSizeFrom(updatedServicePriceListDto.getSizeFrom());
        servicePriceList.setSizeTo(updatedServicePriceListDto.getSizeTo());
        servicePriceList.setInitPrice(updatedServicePriceListDto.getInitPrice());
        servicePriceList.setPriceUnit(updatedServicePriceListDto.getPriceUnit());
        ServicePriceList saveServicePriceList = servicePriceListRepository.save(servicePriceList);
        return ServicePriceListMapper.toDto(saveServicePriceList);
    }

    @Override
    public void deleteServicePriceList(Integer servicePriceListId) {
        ServicePriceList servicePriceList = servicePriceListRepository.findById(servicePriceListId)
                .orElseThrow(() -> new RuntimeException("Service price list is not exist with given Id:" + servicePriceListId));
        servicePriceListRepository.deleteById(servicePriceListId);
    }
}
