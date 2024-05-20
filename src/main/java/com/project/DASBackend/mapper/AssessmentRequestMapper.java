package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AssessmentRequestDto;
import com.project.DASBackend.entity.AssessmentRequest;

public class AssessmentRequestMapper {
    public static AssessmentRequestDto toDto(AssessmentRequest request) {
        if (request == null) {
            return null;
        }

        AssessmentRequestDto dto = new AssessmentRequestDto();
        dto.setRequestId(request.getRequestId());
        dto.setAddress(request.getAddress());
        dto.setDateCreated(request.getDateCreated());
        dto.setMeetingDate(request.getMeetingDate());
        dto.setNumberOfDiamonds(request.getNumberOfDiamonds());
        dto.setPhone(request.getPhone());
        dto.setAccountId(request.getAccount().getAccountId());
        dto.setServiceId(request.getService().getServiceId());

        return dto;
    }

    public static AssessmentRequest toEntity(AssessmentRequestDto dto) {
        if (dto == null) {
            return null;
        }

        AssessmentRequest request = new AssessmentRequest();
        request.setRequestId(dto.getRequestId());
        request.setAddress(dto.getAddress());
        request.setDateCreated(dto.getDateCreated());
        request.setMeetingDate(dto.getMeetingDate());
        request.setNumberOfDiamonds(dto.getNumberOfDiamonds());
        request.setPhone(dto.getPhone());

        // You need to set the account and service entities separately.
        // Assuming you have a method to fetch these entities:
        // request.setAccount(accountService.findById(dto.getAccountId()));
        // request.setService(serviceService.findById(dto.getServiceId()));

        return request;
    }
}
