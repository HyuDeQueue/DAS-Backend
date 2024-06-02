package com.project.DASBackend.controller;

import com.project.DASBackend.dto.AccountDto;
import com.project.DASBackend.dto.ServiceDto;
import com.project.DASBackend.service.AccountService;
import com.project.DASBackend.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin("*")
@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<ServiceDto> createService(@RequestBody ServiceDto serviceDto){
        ServiceDto saveServiceDto=serviceService.createService(serviceDto);
        return new ResponseEntity<>(saveServiceDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ServiceDto> getServiceById(@PathVariable("id") Integer serviceId){
        ServiceDto getServiceID = serviceService.GetServiceById(serviceId);
        return ResponseEntity.ok(getServiceID);
    }

    @GetMapping
    public ResponseEntity<List<ServiceDto>> getServiceList(){
        List<ServiceDto> serviceDtoList = serviceService.GetAllServices();
        return ResponseEntity.ok(serviceDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<ServiceDto> updateService(@RequestBody ServiceDto serviceDto,
                                                    @PathVariable("id") Integer serviceID){
        return ResponseEntity.ok(serviceService.UpdateService(serviceID,serviceDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteServiceById(@PathVariable("id") Integer serviceID){
        serviceService.DeleteService(serviceID);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> changeServiceStatus(@PathVariable("id") Integer serviceId, @RequestParam("status") Integer status) {
        serviceService.changeStatus(serviceId, status);
        return ResponseEntity.noContent().build();
    }
}
