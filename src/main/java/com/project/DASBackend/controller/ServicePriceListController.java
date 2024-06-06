package com.project.DASBackend.controller;

import com.project.DASBackend.dto.ServicePriceListDto;
import com.project.DASBackend.service.ServicePriceListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin("*")
@RestController
@RequestMapping("/api/servicepricelists")
public class ServicePriceListController {

    @Autowired
    private ServicePriceListService servicePriceListService;

    @PostMapping
    public ResponseEntity<ServicePriceListDto> createServicePriceList(@Valid @RequestBody ServicePriceListDto servicePriceListDto) {
        servicePriceListDto = servicePriceListService.createServicePriceList(servicePriceListDto);
        return new ResponseEntity<>(servicePriceListDto, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<ServicePriceListDto> getServicePriceListById(@PathVariable("id") Integer servicePriceListId) {
        ServicePriceListDto servicePriceListDto = servicePriceListService.getServicePriceListById(servicePriceListId);
        return ResponseEntity.ok(servicePriceListDto);
    }

    @GetMapping
    public ResponseEntity<List<ServicePriceListDto>> getAllServicePriceList() {
        List<ServicePriceListDto> servicePriceListDtoList = servicePriceListService.getAllServicePriceList();
        return ResponseEntity.ok(servicePriceListDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<ServicePriceListDto> updateServicePriceList(@Valid @RequestBody ServicePriceListDto servicePriceListDto,
                                                                      @PathVariable("id") Integer servicePriceListId) {
        return ResponseEntity.ok(servicePriceListService.updateServicePriceList(servicePriceListId, servicePriceListDto));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteServicePriceListById(@PathVariable("id") Integer servicePriceListId) {
        servicePriceListService.deleteServicePriceList(servicePriceListId);
        return ResponseEntity.ok("ServicePriceList deleted successfully");
    }

}
