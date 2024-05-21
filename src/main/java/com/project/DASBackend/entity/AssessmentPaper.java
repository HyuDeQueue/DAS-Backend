package com.project.DASBackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Assessment_paper")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Diamond_Id")
    private Integer diamondId;

    @Column(name = "Type", nullable = false)
    private String type;

    @Column(name = "Size", nullable = false)
    private Float size;

    @Column(name = "Shape", nullable = false)
    private String shape;

    @Column(name = "Color", nullable = false)
    private String color;

    @Column(name = "Clarity", nullable = false)
    private String clarity;

    @Column(name = "Polish", nullable = false)
    private String polish;

    @Column(name = "Symmetry", nullable = false)
    private String symmetry;

    @Column(name = "Fluorescence", nullable = false)
    private String fluorescence;

    @Column(name = "Weight", nullable = false)
    private Float weight;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "Date_Created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "Table_Percentage", nullable = false)
    private Float tablePercentage;

    @Column(name = "Depth_Percentage", nullable = false)
    private Float depthPercentage;

    @Column(name = "Crown_Angle", nullable = false)
    private Float crownAngle;

    @Column(name = "Pavilion_Angle", nullable = false)
    private Float pavilionAngle;

    @Column(name = "Girdle_Thickness", nullable = false)
    private String girdleThickness;

    @Column(name = "Culet_Size", nullable = false)
    private Float culetSize;

    @Column(name = "Total_Depth", nullable = false)
    private Float totalDepth;

    @Column(name = "Crown_Height", nullable = false)
    private Float crownHeight;

    @Column(name = "Pavilion_Depth", nullable = false)
    private Float pavilionDepth;

    @Column(name = "Symmetry_Grade", nullable = false)
    private Float symmetryGrade;

    @Column(name = "Seal_Id", unique = true)
    private Integer sealId;

    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Detail_Id", nullable = false)
    private BookingDetail detail;
}
