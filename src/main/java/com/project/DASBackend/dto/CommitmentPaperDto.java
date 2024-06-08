package com.project.DASBackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommitmentPaperDto {

    @NotNull(message = "Commitment ID cannot be null")
    private Integer commitmentId;

    @NotNull(message = "Date created cannot be null")
    @PastOrPresent(message = "Date created must be in the past or present")
    private LocalDateTime dateCreated;

    @NotNull(message = "Approval date cannot be null")
    @PastOrPresent(message = "Approval date must be in the past or present")
    private LocalDateTime approvalDate;

    @NotBlank(message = "Commitment type cannot be blank")
    private String commitmentType;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Status cannot be null")
    @Min(value = 0, message = "Status must be greater than or equal to 0")
    private Integer status;

    @NotNull(message = "Booking ID cannot be null")
    private Integer bookingId;

    @NotNull(message = "Account ID cannot be null")
    private Integer accountId;
}
