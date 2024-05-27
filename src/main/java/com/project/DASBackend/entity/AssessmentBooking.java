package com.project.DASBackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Assessment_Booking")
@Data
@Builder
public class AssessmentBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Booking_Id")
    private Integer bookingId;

    @Column(name = "number_of_diamonds", nullable = false)
    private Integer numberOfDiamonds;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Column(name = "Date_Created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "Diamond_return_date", nullable = false)
    private LocalDateTime diamondReturnDate;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "Payment_type", nullable = false)
    private Integer paymentType;

    @Column(name = "Payment_status", nullable = false)
    private Integer paymentStatus;

    @Column(name = "Feedback")
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Request_Id", nullable = false)
    private AssessmentRequest request;

    @ManyToOne
    @JoinColumn(name = "Service_Id", nullable = false)
    private Services service;
}
