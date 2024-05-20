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
    private Integer totalPrice;
    private LocalDateTime createdDate;
    private LocalDateTime diamondReturnDate;
    private Integer status;
    private Integer paymentType;
    private Integer paymentStatus;
    private Integer dateModified;
    private Integer accountId;
    private Integer requestId;
    private Integer serviceId;
}
