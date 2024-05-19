package com.project.DASBackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentPaperDTO {
    private int diamondId;
    private String type;
    private float size;
    private String shape;
    private char color;
    private String clarity;
    private String polish;
    private String symmetry;
    private String fluorescence;
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
    private Integer sealId;
    private int bookingId;
    private int accountId;
}
