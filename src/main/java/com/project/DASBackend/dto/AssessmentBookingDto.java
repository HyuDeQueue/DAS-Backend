package com.project.DASBackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime dateCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime sampleReturnDate;
    private String feedback;
    private Integer paymentType;
    private Integer paymentStatus;
    private Integer status;
    private Integer accountId;
    private Integer requestId;
    private List<BookingSampleDto> bookingSamples;
}
