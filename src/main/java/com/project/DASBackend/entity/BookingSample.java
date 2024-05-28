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
public class BookingSample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sample_Id")
    private Integer sampleId;

    @Column(name = "IsDiamond", nullable = false)
    private Integer isDiamond;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Size", nullable = false)
    private Float size;

    @Column(name = "Price", nullable = false)
    private Integer price;

    @Column(name = "Status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "Booking_Id", nullable = false)
    private AssessmentBooking booking;

}
