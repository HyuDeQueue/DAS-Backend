package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AssessmentRequestDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentRequest;
import com.project.DASBackend.entity.Service;

public class AssessmentRequestMapper {
    public static AssessmentRequestDto toDto(AssessmentRequest request) {
        if (request == null) {
            return null;
        }
        return new AssessmentRequestDto(
                request.getRequestId(),
                request.getPhone(),
                request.getNumberOfDiamonds(),
                request.getDateCreated(),
                request.getMeetingDate(),
                request.getAddress(),
                request.getAccount().getAccountId(),
                request.getService().getServiceId()
        );
    }

    public static AssessmentRequest toEntity(AssessmentRequestDto requestDto, Account account, Service service) {
        if (requestDto == null) {
            return null;
        }
        AssessmentRequest request = new AssessmentRequest();
        request.setRequestId(requestDto.getRequestId());
        request.setPhone(requestDto.getPhone());
        request.setNumberOfDiamonds(requestDto.getNumberOfDiamonds());
        request.setDateCreated(requestDto.getDateCreated());
        request.setMeetingDate(requestDto.getMeetingDate());
        request.setAddress(requestDto.getAddress());
        request.setAccount(account);
        request.setService(service);
        return request;
    }
}
