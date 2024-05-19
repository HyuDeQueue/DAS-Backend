package com.project.DASBackend.Entity;

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
    private int bookingId;

    @Column(name = "total_price", nullable = false)
    private int totalPrice;

    @Column(name = "Created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "Diamond_return_date", nullable = false)
    private LocalDateTime diamondReturnDate;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "Payment_type", nullable = false)
    private int paymentType;

    @Column(name = "Payment_status", nullable = false)
    private int paymentStatus;

    @Column(name = "Date_Modified", nullable = false)
    private int dateModified;

    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Request_Id", nullable = false)
    private AssessmentRequest assessmentRequest;

    @ManyToOne
    @JoinColumn(name = "Service_Id", nullable = false)
    private Service service;
}
