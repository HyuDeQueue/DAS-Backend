package com.project.DASBackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "Booking ID cannot be null")
    private Integer bookingId;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    private Integer quantity;

    @NotNull(message = "Total price cannot be null")
    @Min(value = 0, message = "Total price must be greater than or equal to 0")
    private Integer totalPrice;

    @PastOrPresent(message = "Birthdate must be in the past or present")
    @NotNull(message = "Date created cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime dateCreated;

    @FutureOrPresent(message = "Sample return date must be in the future or present")
    @NotNull(message = "Sample return date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime sampleReturnDate;

    private String feedback;

    @NotNull(message = "Payment type cannot be null")
    @Min(value = 0, message = "Payment type must be greater than or equal to 0")
    private Integer paymentType;

    @NotNull(message = "Payment status cannot be null")
    @Min(value = 0, message = "Payment status must be greater than or equal to 0")
    private Integer paymentStatus;

    @NotNull(message = "Status cannot be null")
    @Min(value = 0, message = "Status must be greater than or equal to 0")
    private Integer status;

    @NotNull(message = "Account ID cannot be null")
    private Integer accountId;

    @NotNull(message = "Request ID cannot be null")
    private Integer requestId;


    private List<BookingSampleDto> bookingSamples;
}
