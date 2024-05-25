package com.project.DASBackend.service;

import com.project.DASBackend.dto.CommitmentPaperDto;

import java.util.List;

public interface CommitmentPaperService {
    CommitmentPaperDto createCommitmentPaper(CommitmentPaperDto commitmentPaperDto);
    CommitmentPaperDto getCommitmentPaperById(Integer commitmentPaperId);
    List<CommitmentPaperDto> getAllCommitmentPapers();
    CommitmentPaperDto updateCommitmentPaper(Integer commitmentPaperId, CommitmentPaperDto updatedCommitmentPaper);
    void deleteCommitmentPaper(Integer commitmentPaperId);
}
