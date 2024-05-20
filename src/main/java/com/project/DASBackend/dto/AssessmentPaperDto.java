package com.project.DASBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentPaperDto {
    private Integer diamondId;
    private String type;
    private float size;
    private String shape;
    private char color;
    private String clarity;
    private String polish;
    private String symmetry;
    private String flourescence;
    private float weight;
    private String comments;
    private LocalDateTime dateCreated;
    private float tablePercentage;
    private float depthPercentage;
    private float crownAngle;
    private float pavilionAngle;
    private String girdleThickness;
    private float culetSize;
    private float totalDepth;
    private float crownHeight;
    private float pavilionDepth;
    private float symmetryGrade;
    private String feedback;
    private Integer sealId;
    private Integer bookingId;
    private Integer accountId;

}
