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

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Column(name = "Date_Created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "Diamond_return_date", nullable = false)
    private LocalDateTime sampleReturnDate;

    @Column(name = "Feedback")
    private String feedback;

    @Column(name = "Payment_type", nullable = false)
    private Integer paymentType;

    @Column(name = "Payment_status", nullable = false)
    private Integer paymentStatus;

    @Column(name = "status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Request_Id", nullable = false)
    private AssessmentRequest request;

    public int getNumberOfDiamonds() {
        return quantity;
    }
}
