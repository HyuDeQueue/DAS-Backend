package com.project.DASBackend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AssessmentBookingDto {
    private Integer bookingId;
    private Integer quantity;
    private Integer totalPrice;
    private LocalDateTime dateCreated;
    private LocalDateTime sampleReturnDate;
    private String feedback;
    private Integer paymentType;
    private Integer paymentStatus;
    private Integer status;
    private Integer accountId;
    private Integer requestId;
}
