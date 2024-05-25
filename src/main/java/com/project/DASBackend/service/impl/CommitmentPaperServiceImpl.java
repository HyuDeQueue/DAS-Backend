package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.CommitmentPaperDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentBooking;
import com.project.DASBackend.entity.AssessmentRequest;
import com.project.DASBackend.entity.CommitmentPaper;
import com.project.DASBackend.exception.ResourceNotFoundException;
import com.project.DASBackend.mapper.CommitmentPaperMapper;
import com.project.DASBackend.repository.AccountRepository;
import com.project.DASBackend.repository.AssessmentBookingRepository;
import com.project.DASBackend.repository.CommitmentPaperRepository;
import com.project.DASBackend.service.CommitmentPaperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommitmentPaperServiceImpl implements CommitmentPaperService {

    private CommitmentPaperRepository commitmentPaperRepository;
    private AssessmentBookingRepository assessmentBookingRepository;
    private AccountRepository accountRepository;


    @Override
    public CommitmentPaperDto createCommitmentPaper(CommitmentPaperDto commitmentPaperDto) {
        Account account = accountRepository.findById(commitmentPaperDto.getAccountId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account not found with given Id: " + commitmentPaperDto.getAccountId()));
        AssessmentBooking booking = assessmentBookingRepository.findById(commitmentPaperDto.getBookingId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Assessment booking not found with given Id: " + commitmentPaperDto.getBookingId()));

        CommitmentPaper commitmentPaper = CommitmentPaperMapper.toEntity(commitmentPaperDto, booking, account);
        CommitmentPaper savedCommitmentPaper = commitmentPaperRepository.save(commitmentPaper);
        return CommitmentPaperMapper.toDto(savedCommitmentPaper);
    }

    @Override
    public CommitmentPaperDto getCommitmentPaperById(Integer commitmentPaperId) {
        CommitmentPaper commitmentPaper = commitmentPaperRepository.findById(commitmentPaperId)
                .orElseThrow(() -> new ResourceNotFoundException("Commitment paper not found with given Id: " + commitmentPaperId));
        return CommitmentPaperMapper.toDto(commitmentPaper);
    }

    @Override
    public List<CommitmentPaperDto> getAllCommitmentPapers() {
        List<CommitmentPaper> commitmentPapers = commitmentPaperRepository.findAll();
        return commitmentPapers.stream().map(commitmentPaper -> CommitmentPaperMapper.toDto(commitmentPaper)).collect(Collectors.toList());
    }

    @Override
    public CommitmentPaperDto updateCommitmentPaper(Integer commitmentPaperId, CommitmentPaperDto updatedCommitmentPaper) {
        CommitmentPaper commitmentPaper = commitmentPaperRepository.findById(commitmentPaperId).orElseThrow(
                () -> new ResourceNotFoundException("Commitment paper not found with given Id: " + commitmentPaperId)
        );
        if (!commitmentPaper.getAccount().getAccountId().equals(updatedCommitmentPaper.getAccountId())) {
            Account account = accountRepository.findById(updatedCommitmentPaper.getAccountId())
                    .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
            commitmentPaper.setAccount(account);
        }

        if (!commitmentPaper.getBooking().getBookingId().equals(updatedCommitmentPaper.getBookingId())) {
            com.project.DASBackend.entity.AssessmentBooking booking = assessmentBookingRepository.findById(updatedCommitmentPaper.getBookingId())
                    .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
            commitmentPaper.setBooking(booking);
        }

        commitmentPaper.setCommitmentId(updatedCommitmentPaper.getCommitmentId());
        commitmentPaper.setApprovalDate(updatedCommitmentPaper.getApprovalDate());
        commitmentPaper.setCommitmentType(updatedCommitmentPaper.getCommitmentType());
        commitmentPaper.setDateCreated(updatedCommitmentPaper.getDateCreated());
        commitmentPaper.setDescription(updatedCommitmentPaper.getDescription());

        CommitmentPaper updatedCommitmentPaperObj = commitmentPaperRepository.save(commitmentPaper);
        return CommitmentPaperMapper.toDto(updatedCommitmentPaperObj);
    }

    @Override
    public void deleteCommitmentPaper(Integer commitmentPaperId) {
        CommitmentPaper commitmentPaper = commitmentPaperRepository.findById(commitmentPaperId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Commitment paper not found with the given Id: " + commitmentPaperId));
        commitmentPaperRepository.deleteById(commitmentPaperId);
    }
}
