package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.CommitmentPaperDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentBooking;
import com.project.DASBackend.entity.CommitmentPaper;

public class CommitmentPaperMapper {
    public static CommitmentPaperDto toDto(CommitmentPaper paper) {
        if (paper == null) {
            return null;
        }
        return new CommitmentPaperDto(
                paper.getCommitmentId(),
                paper.getDateCreated(),
                paper.getApprovalDate(),
                paper.getCommitmentType(),
                paper.getDescription(),
                paper.getBooking().getBookingId(),
                paper.getAccount().getAccountId()
        );
    }

    public static CommitmentPaper toEntity(CommitmentPaperDto paperDto, AssessmentBooking booking, Account account) {
        if (paperDto == null) {
            return null;
        }
        CommitmentPaper paper = new CommitmentPaper();
        paper.setCommitmentId(paperDto.getCommitmentId());
        paper.setDateCreated(paperDto.getDateCreated());
        paper.setApprovalDate(paperDto.getApprovalDate());
        paper.setCommitmentType(paperDto.getCommitmentType());
        paper.setDescription(paperDto.getDescription());
        paper.setBooking(booking);
        paper.setAccount(account);
        return paper;
    }
}
