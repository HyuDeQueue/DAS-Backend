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
    private float size;

    @Column(name = "Shape", nullable = false)
    private String shape;

    @Column(name = "Color", nullable = false)
    private char color;

    @Column(name = "Clarity", nullable = false)
    private String clarity;

    @Column(name = "Polish", nullable = false)
    private String polish;

    @Column(name = "Symmetry", nullable = false)
    private String symmetry;

    @Column(name = "Flourescence", nullable = false)
    private String flourescence;

    @Column(name = "Weight", nullable = false)
    private float weight;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "Date_Created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "Table_Percentage", nullable = false)
    private float tablePercentage;

    @Column(name = "Depth_Percentage", nullable = false)
    private float depthPercentage;

    @Column(name = "Crown_Angle", nullable = false)
    private float crownAngle;

    @Column(name = "Pavilion_Angle", nullable = false)
    private float pavilionAngle;

    @Column(name = "Girdle_Thickness", nullable = false)
    private String girdleThickness;

    @Column(name = "Culet_Size", nullable = false)
    private float culetSize;

    @Column(name = "Total_Depth", nullable = false)
    private float totalDepth;

    @Column(name = "Crown_Height", nullable = false)
    private float crownHeight;

    @Column(name = "Pavilion_Depth", nullable = false)
    private float pavilionDepth;

    @Column(name = "Symmetry_Grade", nullable = false)
    private float symmetryGrade;

    @Column(name = "Feedback")
    private String feedback;

    @Column(name = "Seal_Id", unique = true, nullable = false)
    private Integer sealId;

    @ManyToOne
    @JoinColumn(name = "Booking_Id", nullable = false)
    private AssessmentBooking assessmentBooking;

    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account;
}
