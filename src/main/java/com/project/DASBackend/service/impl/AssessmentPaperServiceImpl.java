package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.AssessmentPaperDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentPaper;
import com.project.DASBackend.entity.BookingSample;
import com.project.DASBackend.exception.ResourceNotFoundException;
import com.project.DASBackend.mapper.AssessmentPaperMapper;
import com.project.DASBackend.repository.AccountRepository;
import com.project.DASBackend.repository.AssessmentPaperRepository;
import com.project.DASBackend.repository.BookingSampleRepository;
import com.project.DASBackend.service.AssessmentPaperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AssessmentPaperServiceImpl implements AssessmentPaperService {

    private AssessmentPaperRepository assessmentPaperRepository;
    private AccountRepository accountRepository;
    private BookingSampleRepository bookingSampleRepository;

    @Override
    public AssessmentPaperDto createAssessmentPaper(AssessmentPaperDto assessmentPaperDto) {
        Account account = accountRepository.findById(assessmentPaperDto.getAccountId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account not found with given Id: " + assessmentPaperDto.getAccountId()));
        BookingSample bookingSample = bookingSampleRepository.findById(assessmentPaperDto.getDetailId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Booking detail not found with given Id: " + assessmentPaperDto.getDetailId()));
        AssessmentPaper assessmentPaper = AssessmentPaperMapper.toEntity(assessmentPaperDto, account, bookingSample);
        AssessmentPaper savedAssessmentPaper = assessmentPaperRepository.save(assessmentPaper);
        return AssessmentPaperMapper.toDto(savedAssessmentPaper);
    }

    @Override
    public AssessmentPaperDto getAssessmentPaperById(Integer paperId) {
        AssessmentPaper assessmentPaper = assessmentPaperRepository.findById(paperId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment paper not found with given Id: " + paperId));
        return AssessmentPaperMapper.toDto(assessmentPaper);
    }

    @Override
    public List<AssessmentPaperDto> getAllAssessmentPapers() {
        List<AssessmentPaper> assessmentPapers = assessmentPaperRepository.findAll();
        return assessmentPapers.stream().map(AssessmentPaperMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssessmentPaperDto updateAssessmentPaper(AssessmentPaperDto updatedAssessmentPaperDto, Integer paperId) {
        AssessmentPaper assessmentPaper = assessmentPaperRepository.findById(paperId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment paper not found with given Id: " + paperId));
        if(!updatedAssessmentPaperDto.getAccountId().equals(updatedAssessmentPaperDto.getAccountId())){
            Account account = accountRepository.findById(updatedAssessmentPaperDto.getAccountId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Account not found with given Id: " + updatedAssessmentPaperDto.getAccountId()));
            assessmentPaper.setAccount(account);
        }

        if(!updatedAssessmentPaperDto.getDetailId().equals(updatedAssessmentPaperDto.getDetailId())){
            BookingSample bookingSample = bookingSampleRepository.findById(updatedAssessmentPaperDto.getDetailId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Booking detail not found with given Id: " + updatedAssessmentPaperDto.getDetailId()));
            assessmentPaper.setDetail(bookingSample);
        }

        assessmentPaper.setType(updatedAssessmentPaperDto.getType());
        assessmentPaper.setSize(updatedAssessmentPaperDto.getSize());
        assessmentPaper.setShape(updatedAssessmentPaperDto.getShape());
        assessmentPaper.setColor(updatedAssessmentPaperDto.getColor());
        assessmentPaper.setClarity(updatedAssessmentPaperDto.getClarity());
        assessmentPaper.setPolish(updatedAssessmentPaperDto.getPolish());
        assessmentPaper.setSymmetry(updatedAssessmentPaperDto.getSymmetry());
        assessmentPaper.setFluorescence(updatedAssessmentPaperDto.getFluorescence());
        assessmentPaper.setWeight(updatedAssessmentPaperDto.getWeight());
        assessmentPaper.setComments(updatedAssessmentPaperDto.getComments());
        assessmentPaper.setDateCreated(updatedAssessmentPaperDto.getDateCreated());
        assessmentPaper.setTablePercentage(updatedAssessmentPaperDto.getTablePercentage());
        assessmentPaper.setDepthPercentage(updatedAssessmentPaperDto.getDepthPercentage());
        assessmentPaper.setCrownAngle(updatedAssessmentPaperDto.getCrownAngle());
        assessmentPaper.setPavilionAngle(updatedAssessmentPaperDto.getPavilionAngle());
        assessmentPaper.setGirdleThickness(updatedAssessmentPaperDto.getGirdleThickness());
        assessmentPaper.setCuletSize(updatedAssessmentPaperDto.getCuletSize());
        assessmentPaper.setTotalDepth(updatedAssessmentPaperDto.getTotalDepth());
        assessmentPaper.setCrownHeight(updatedAssessmentPaperDto.getCrownHeight());
        assessmentPaper.setPavilionDepth(updatedAssessmentPaperDto.getPavilionDepth());
        assessmentPaper.setSymmetryGrade(updatedAssessmentPaperDto.getSymmetryGrade());
        assessmentPaper.setCrossSection(updatedAssessmentPaperDto.getCrossSection());
        assessmentPaper.setLongitudinalSection(updatedAssessmentPaperDto.getLongitudinalSection());
        assessmentPaper.setTransverseSection(updatedAssessmentPaperDto.getTransverseSection());
        assessmentPaper.setSealId(updatedAssessmentPaperDto.getSealId());

        AssessmentPaper savedAssessmentPaper = assessmentPaperRepository.save(assessmentPaper);
        return AssessmentPaperMapper.toDto(savedAssessmentPaper);
    }

    @Override
    public void deleteAssessmentPaper(Integer paperId) {
        AssessmentPaper assessmentPaper = assessmentPaperRepository.findById(paperId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment paper not found with given Id: " + paperId));
        assessmentPaperRepository.deleteById(paperId);
    }
}
