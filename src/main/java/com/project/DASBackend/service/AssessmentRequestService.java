package com.project.DASBackend.service;

import com.project.DASBackend.dto.AssessmentRequestDto;

import java.util.List;

public interface AssessmentRequestService {
    AssessmentRequestDto createAssessmentRequest(AssessmentRequestDto assessmentRequestDto);

    AssessmentRequestDto getAssessmentRequestById(Integer requestId);

    List<AssessmentRequestDto> getAllAssessmentRequests();

    AssessmentRequestDto updateAssessmentRequest(AssessmentRequestDto assessmentRequestDto, Integer requestId);

    void deleteAssessmentRequest(Integer requestId);

    void changeStatus(Integer requestId, Integer status);
}
