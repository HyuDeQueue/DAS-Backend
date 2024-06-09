package com.project.DASBackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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

    @NotBlank(message = "Type cannot be blank")
    private String type;

    @NotNull(message = "Size cannot be null")
    private Float size;

    @NotBlank(message = "Shape cannot be blank")
    private String shape;

    @NotBlank(message = "Color cannot be blank")
    private String color;

    @NotBlank(message = "Clarity cannot be blank")
    private String clarity;

    @NotBlank(message = "Polish cannot be blank")
    private String polish;

    @NotBlank(message = "Symmetry cannot be blank")
    private String symmetry;

    @NotBlank(message = "Fluorescence cannot be blank")
    private String fluorescence;

    @NotNull(message = "Weight cannot be null")
    @Min(value = 0, message = "Weight must be greater than or equal to 0")
    private Float weight;

    private String comments;

    @NotNull(message = "Date created cannot be null")
    @PastOrPresent(message = "Date created must be in the past or present")
    private LocalDateTime dateCreated;

    @NotNull(message = "Table percentage cannot be null")
    private Float tablePercentage;

    @NotNull(message = "Girdle percentage cannot be null")
    private Float depthPercentage;

    @NotNull(message = "Crown angle cannot be null")
    private Float crownAngle;

    @NotNull(message = "Pavilion angle cannot be null")
    private Float pavilionAngle;

    @NotBlank(message = "Girdle thickness cannot be blank")
    private String girdleThickness;

    @NotNull(message = "Culet size cannot be null")
    private Float culetSize;

    @NotNull(message = "Total depth cannot be null")
    private Float totalDepth;

    @NotNull(message = "Crown height cannot be null")
    private Float crownHeight;

    @NotNull(message = "Pavilion depth cannot be null")
    private Float pavilionDepth;

    @NotNull(message = "Symmetry grade cannot be null")
    private Float symmetryGrade;

    @NotBlank(message = "Cross section cannot be blank")
    private String crossSection;

    @NotBlank(message = "Longitudinal section cannot be blank")
    private String longitudinalSection;

    @NotBlank(message = "Transverse section cannot be blank")
    private String transverseSection;

    @NotNull(message = "Seal ID cannot be null")
    private Integer sealId;

    @NotNull(message = "Account ID cannot be null")
    private Integer accountId;

    @NotNull(message = "Sample ID cannot be null")
    private Integer sampleId;

}
