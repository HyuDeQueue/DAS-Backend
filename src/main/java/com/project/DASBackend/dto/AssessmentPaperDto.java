package com.project.DASBackend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AssessmentPaperDto {
    private Integer diamondId;
    private String type;
    private Float size;
    private String shape;
    private String color;
    private String clarity;
    private String polish;
    private String symmetry;
    private String fluorescence;
    private Float weight;
    private String comments;
    private LocalDateTime dateCreated;
    private Float tablePercentage;
    private Float depthPercentage;
    private Float crownAngle;
    private Float pavilionAngle;
    private String girdleThickness;
    private Float culetSize;
    private Float totalDepth;
    private Float crownHeight;
    private Float pavilionDepth;
    private Float symmetryGrade;
    private String crossSection;
    private String longitudinalSection;
    private String transverseSection;
    private Integer sealId;
    private Integer accountId;
    private Integer detailId;

}
