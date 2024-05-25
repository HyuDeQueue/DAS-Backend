package com.project.DASBackend.service;

import com.project.DASBackend.dto.AssessmentPaperDto;

import java.util.List;

public interface AssessmentPaperService {
    AssessmentPaperDto createAssessmentPaper(AssessmentPaperDto assessmentPaperDto);

    AssessmentPaperDto getAssessmentPaperById(Integer paperId);

    List<AssessmentPaperDto> getAllAssessmentPapers();

    AssessmentPaperDto updateAssessmentPaper(AssessmentPaperDto updatedAssessmentPaperDto, Integer paperId);

    void deleteAssessmentPaper(Integer paperId);
}
