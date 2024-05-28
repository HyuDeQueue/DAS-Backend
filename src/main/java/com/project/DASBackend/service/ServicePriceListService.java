package com.project.DASBackend.service;

import com.project.DASBackend.dto.ServicePriceListDto;

import java.util.List;

public interface ServicePriceListService {
    ServicePriceListDto createServicePriceList(ServicePriceListDto servicePriceListDto);
    ServicePriceListDto getServicePriceListById(Integer servicePriceListId);
    List<ServicePriceListDto> getAllServicePriceList();
    ServicePriceListDto updateServicePriceList(Integer servicePriceListId, ServicePriceListDto servicePriceListDto);
    void deleteServicePriceList(Integer servicePriceListId);
}
