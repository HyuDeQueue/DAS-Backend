package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.ServicePriceListDto;
import com.project.DASBackend.entity.ServicePriceList;
import com.project.DASBackend.entity.Services;

public class ServicePriceListMapper {
    public static ServicePriceListDto toDto(ServicePriceList servicePriceList) {
        if (servicePriceList == null) {
            return null;
        }
        return new ServicePriceListDto(
                servicePriceList.getServicePriceId(),
                servicePriceList.getSizeFrom(),
                servicePriceList.getSizeTo(),
                servicePriceList.getInitPrice(),
                servicePriceList.getPriceUnit(),
                servicePriceList.getService().getServiceId()
        );
    }

    public static ServicePriceList toEntity(ServicePriceListDto servicePriceListDto, Services services) {
        if (servicePriceListDto == null) {
            return null;
        }
        ServicePriceList servicePriceList = new ServicePriceList();
        servicePriceList.setServicePriceId(servicePriceListDto.getServicePriceId());
        servicePriceList.setSizeFrom(servicePriceListDto.getSizeFrom());
        servicePriceList.setSizeTo(servicePriceListDto.getSizeTo());
        servicePriceList.setInitPrice(servicePriceListDto.getInitPrice());
        servicePriceList.setPriceUnit(servicePriceListDto.getPriceUnit());
        servicePriceList.setService(services);
        return servicePriceList;
    }
}
