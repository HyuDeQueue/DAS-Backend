package com.project.DASBackend.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AssessmentBookingDTO {
    private int bookingId;
    private int totalPrice;
    private LocalDateTime createdDate;
    private LocalDateTime diamondReturnDate;
    private int status;
    private int paymentType;
    private int paymentStatus;
    private int dateModified;
    private int accountId;
    private int requestId;
    private int serviceId;
}
