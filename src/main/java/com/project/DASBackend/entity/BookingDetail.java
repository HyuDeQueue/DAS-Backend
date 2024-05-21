package com.project.DASBackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Booking_Detail")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Detail_Id")
    private Integer detailId;

    @Column(name = "Status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "Booking_Id", nullable = false)
    private AssessmentBooking booking;

}
