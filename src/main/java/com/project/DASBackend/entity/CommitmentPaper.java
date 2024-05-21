package com.project.DASBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Commitment_Paper")
public class CommitmentPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Commitment_Id")
    private Integer commitmentId;

    @Column(name = "Date_Created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "ApprovalDate", nullable = false)
    private LocalDateTime approvalDate;

    @Column(name = "CommitmentType", nullable = false)
    private String commitmentType;

    @Column(name = "Description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "Booking_Id", nullable = false)
    private AssessmentBooking booking;

    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account;
}