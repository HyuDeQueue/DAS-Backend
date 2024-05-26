package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AssessmentPaperDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.entity.AssessmentPaper;
import com.project.DASBackend.entity.BookingDetail;
public class AssessmentPaperMapper {
    public static AssessmentPaperDto toDto(AssessmentPaper paper) {
        if (paper == null) {
            return null;
        }
        return new AssessmentPaperDto(
                paper.getDiamondId(),
                paper.getType(),
                paper.getSize(),
                paper.getShape(),
                paper.getColor(),
                paper.getClarity(),
                paper.getPolish(),
                paper.getSymmetry(),
                paper.getFluorescence(),
                paper.getWeight(),
                paper.getComments(),
                paper.getDateCreated(),
                paper.getTablePercentage(),
                paper.getDepthPercentage(),
                paper.getCrownAngle(),
                paper.getPavilionAngle(),
                paper.getGirdleThickness(),
                paper.getCuletSize(),
                paper.getTotalDepth(),
                paper.getCrownHeight(),
                paper.getPavilionDepth(),
                paper.getSymmetryGrade(),
                paper.getCrossSection(),
                paper.getLongitudinalSection(),
                paper.getTransverseSection(),
                paper.getSealId(),
                paper.getAccount().getAccountId(),
                paper.getDetail().getDetailId()
        );
    }

    public static AssessmentPaper toEntity(AssessmentPaperDto paperDto, Account account, BookingDetail detail) {
        if (paperDto == null) {
            return null;
        }
        AssessmentPaper paper = new AssessmentPaper();
        paper.setDiamondId(paperDto.getDiamondId());
        paper.setType(paperDto.getType());
        paper.setSize(paperDto.getSize());
        paper.setShape(paperDto.getShape());
        paper.setColor(paperDto.getColor());
        paper.setClarity(paperDto.getClarity());
        paper.setPolish(paperDto.getPolish());
        paper.setSymmetry(paperDto.getSymmetry());
        paper.setFluorescence(paperDto.getFluorescence());
        paper.setWeight(paperDto.getWeight());
        paper.setComments(paperDto.getComments());
        paper.setDateCreated(paperDto.getDateCreated());
        paper.setTablePercentage(paperDto.getTablePercentage());
        paper.setDepthPercentage(paperDto.getDepthPercentage());
        paper.setCrownAngle(paperDto.getCrownAngle());
        paper.setPavilionAngle(paperDto.getPavilionAngle());
        paper.setGirdleThickness(paperDto.getGirdleThickness());
        paper.setCuletSize(paperDto.getCuletSize());
        paper.setTotalDepth(paperDto.getTotalDepth());
        paper.setCrownHeight(paperDto.getCrownHeight());
        paper.setPavilionDepth(paperDto.getPavilionDepth());
        paper.setSymmetryGrade(paperDto.getSymmetryGrade());
        paper.setCrossSection(paperDto.getCrossSection());
        paper.setLongitudinalSection(paperDto.getLongitudinalSection());
        paper.setTransverseSection(paperDto.getTransverseSection());
        paper.setSealId(paperDto.getSealId());
        paper.setAccount(account);
        paper.setDetail(detail);
        return paper;
    }
}