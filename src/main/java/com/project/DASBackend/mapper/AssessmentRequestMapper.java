package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AssessmentRequestDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentRequest;
import com.project.DASBackend.entity.Services;

public class AssessmentRequestMapper {
    public static AssessmentRequestDto toDto(AssessmentRequest request) {
        if (request == null) {
            return null;
        }
        return new AssessmentRequestDto(
                request.getRequestId(),
                request.getName(),
                request.getPhone(),
                request.getNumberOfSamples(),
                request.getDateCreated(),
                request.getMeetingDate(),
                request.getAddress(),
                request.getStatus(),
                request.getAccount().getAccountId(),
                request.getService().getServiceId()
        );
    }

    public static AssessmentRequest toEntity(AssessmentRequestDto requestDto, Account account, Services service) {
        if (requestDto == null) {
            return null;
        }
        AssessmentRequest request = new AssessmentRequest();
        request.setRequestId(requestDto.getRequestId());
        request.setName(requestDto.getName());
        request.setPhone(requestDto.getPhone());
        request.setNumberOfSamples(requestDto.getNumberOfSamples());
        request.setDateCreated(requestDto.getDateCreated());
        request.setMeetingDate(requestDto.getMeetingDate());
        request.setAddress(requestDto.getAddress());
        request.setStatus(requestDto.getStatus());
        request.setAccount(account);
        request.setService(service);
        return request;
    }
}
