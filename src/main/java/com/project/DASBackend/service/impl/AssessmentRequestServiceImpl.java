package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.AssessmentRequestDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentRequest;
import com.project.DASBackend.entity.Services;
import com.project.DASBackend.entity.Services;
import com.project.DASBackend.exception.ResourceNotFoundException;
import com.project.DASBackend.mapper.AssessmentRequestMapper;
import com.project.DASBackend.repository.AccountRepository;
import com.project.DASBackend.repository.AssessmentRequestRepository;
import com.project.DASBackend.repository.ServiceRepository;
import com.project.DASBackend.service.AssessmentRequestService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class AssessmentRequestServiceImpl implements AssessmentRequestService {

    private AssessmentRequestRepository assessmentRequestRepository;
    private AccountRepository accountRepository;  // Assuming you have a repository for Account
    private ServiceRepository serviceRepository;  // Assuming you have a repository for Service

    @Override
    public AssessmentRequestDto createAssessmentRequest(AssessmentRequestDto assessmentRequestDto) {
        // Fetch Account and Service objects based on identifiers from the DTO (e.g., accountId, serviceId)
        Account account = accountRepository.findById(assessmentRequestDto.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        Services service = serviceRepository.findById(assessmentRequestDto.getServiceId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));

        AssessmentRequest assessmentRequest = AssessmentRequestMapper.toEntity(assessmentRequestDto, account, service);
        AssessmentRequest savedAssessmentRequest = assessmentRequestRepository.save(assessmentRequest);
        return AssessmentRequestMapper.toDto(savedAssessmentRequest);
    }

    @Override
    public AssessmentRequestDto getAssessmentRequestById(Integer requestId) {
        AssessmentRequest assessmentRequest = assessmentRequestRepository.findById(requestId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment request not found with the given ID: "+requestId));
        return AssessmentRequestMapper.toDto(assessmentRequest);
    }

    @Override
    public List<AssessmentRequestDto> getAllAssessmentRequests() {
        List<AssessmentRequest> assessmentRequests = assessmentRequestRepository.findAll();
        return assessmentRequests.stream().map(assessmentRequest -> AssessmentRequestMapper.toDto(assessmentRequest))
                .collect(Collectors.toList());
    }

    @Override
    public AssessmentRequestDto updateAssessmentRequest(AssessmentRequestDto updatedAssessmentRequestDto, Integer requestId) {
        AssessmentRequest assessmentRequest = assessmentRequestRepository.findById(requestId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment request not found with the given ID: "+requestId));

        assessmentRequest.setPhone(updatedAssessmentRequestDto.getPhone());
        assessmentRequest.setNumberOfSamples(updatedAssessmentRequestDto.getNumberOfSamples());
        assessmentRequest.setDateCreated(updatedAssessmentRequestDto.getDateCreated());
        assessmentRequest.setMeetingDate(updatedAssessmentRequestDto.getMeetingDate());
        assessmentRequest.setAddress(updatedAssessmentRequestDto.getAddress());
        assessmentRequest.setStatus(updatedAssessmentRequestDto.getStatus());

        if (!assessmentRequest.getAccount().getAccountId().equals(updatedAssessmentRequestDto.getAccountId())) {
            Account account = accountRepository.findById(updatedAssessmentRequestDto.getAccountId())
                    .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
            assessmentRequest.setAccount(account);
        }

        if (!assessmentRequest.getService().getServiceId().equals(updatedAssessmentRequestDto.getServiceId())) {
            Services service = serviceRepository.findById(updatedAssessmentRequestDto.getServiceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Service not found"));
            assessmentRequest.setService(service);
        }

        AssessmentRequest updatedAssessmentRequest = assessmentRequestRepository.save(assessmentRequest);
        return AssessmentRequestMapper.toDto(updatedAssessmentRequest);
    }

    @Override
    public void deleteAssessmentRequest(Integer requestId) {
        AssessmentRequest assessmentRequest = assessmentRequestRepository.findById(requestId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment request not found with the given ID: "+requestId));
        assessmentRequestRepository.deleteById(requestId);
    }
}
