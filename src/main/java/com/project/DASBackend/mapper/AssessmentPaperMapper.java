package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AssessmentPaperDto;
import com.project.DASBackend.entity.AssessmentPaper;

public class AssessmentPaperMapper {
    public static AssessmentPaperDto toDto(AssessmentPaper paper) {
        if (paper == null) {
            return null;
        }

        AssessmentPaperDto dto = new AssessmentPaperDto();
        dto.setDiamondId(paper.getDiamondId());
        dto.setClarity(paper.getClarity());
        dto.setColor(paper.getColor());
        dto.setComments(paper.getComments());
        dto.setCrownAngle(paper.getCrownAngle());
        dto.setCrownHeight(paper.getCrownHeight());
        dto.setCuletSize(paper.getCuletSize());
        dto.setDateCreated(paper.getDateCreated());
        dto.setDepthPercentage(paper.getDepthPercentage());
        dto.setFlourescence(paper.getFlourescence());
        dto.setGirdleThickness(paper.getGirdleThickness());
        dto.setPavilionAngle(paper.getPavilionAngle());
        dto.setPavilionDepth(paper.getPavilionDepth());
        dto.setPolish(paper.getPolish());
        dto.setSealId(paper.getSealId());
        dto.setShape(paper.getShape());
        dto.setSize(paper.getSize());
        dto.setSymmetry(paper.getSymmetry());
        dto.setSymmetryGrade(paper.getSymmetryGrade());
        dto.setTablePercentage(paper.getTablePercentage());
        dto.setTotalDepth(paper.getTotalDepth());
        dto.setType(paper.getType());
        dto.setWeight(paper.getWeight());
        dto.setAccountId(paper.getAccount().getAccountId());
        dto.setBookingId(paper.getAssessmentBooking().getBookingId());
        dto.setFeedback(paper.getFeedback());

        return dto;
    }

    public static AssessmentPaper toEntity(AssessmentPaperDto dto) {
        if (dto == null) {
            return null;
        }

        AssessmentPaper paper = new AssessmentPaper();
        paper.setDiamondId(dto.getDiamondId());
        paper.setClarity(dto.getClarity());
        paper.setColor(dto.getColor());
        paper.setComments(dto.getComments());
        paper.setCrownAngle(dto.getCrownAngle());
        paper.setCrownHeight(dto.getCrownHeight());
        paper.setCuletSize(dto.getCuletSize());
        paper.setDateCreated(dto.getDateCreated());
        paper.setDepthPercentage(dto.getDepthPercentage());
        paper.setFlourescence(dto.getFlourescence());
        paper.setGirdleThickness(dto.getGirdleThickness());
        paper.setPavilionAngle(dto.getPavilionAngle());
        paper.setPavilionDepth(dto.getPavilionDepth());
        paper.setPolish(dto.getPolish());
        paper.setSealId(dto.getSealId());
        paper.setShape(dto.getShape());
        paper.setSize(dto.getSize());
        paper.setSymmetry(dto.getSymmetry());
        paper.setSymmetryGrade(dto.getSymmetryGrade());
        paper.setTablePercentage(dto.getTablePercentage());
        paper.setTotalDepth(dto.getTotalDepth());
        paper.setType(dto.getType());
        paper.setWeight(dto.getWeight());

        // You need to set the account and booking entities separately.
        // Assuming you have a method to fetch these entities:
        // paper.setAccount(accountService.findById(dto.getAccountId()));
        // paper.setBooking(bookingService.findById(dto.getBookingId()));

        paper.setFeedback(dto.getFeedback());

        return paper;
    }
}
