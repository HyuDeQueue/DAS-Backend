package com.project.DASBackend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Assessment_Request")
@Data
@Builder
public class AssessmentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Request_Id")
    private int requestId;

    @Column(name = "Phone", nullable = false)
    private String phone;

    @Column(name = "Number_of_diamonds", nullable = false)
    private int numberOfDiamonds;

    @Column(name = "Date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "Meeting_date", nullable = false)
    private LocalDateTime meetingDate;

    @Column(name = "Address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Service_Id", nullable = false)
    private Service service;
}
