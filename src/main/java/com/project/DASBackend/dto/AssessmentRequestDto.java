package com.project.DASBackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentRequestDto {

    @NotNull(message = "Request ID cannot be null")
    @Min(value = 0, message = "Request ID must be greater than or equal to 0")
    private Integer requestId;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Phone cannot be blank")
    private String phone;

    @NotNull(message = "Number of samples cannot be null")
    @Min(value = 0, message = "Number of samples must be greater than or equal to 0")
    private Integer numberOfSamples;

    @NotNull(message = "Date created cannot be null")
    @PastOrPresent(message = "Date created must be in the past or present")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime dateCreated;

    @NotNull(message = "Meeting time cannot be null")
    private String meetingTime;

    @NotNull(message = "Meeting date cannot be null")
    @FutureOrPresent(message = "Meeting date must be in the future or present")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime meetingDate;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotNull(message = "Status cannot be null")
    @Min(value = 0, message = "Status must be greater than or equal to 0")
    private Integer status;

    @NotNull(message = "Account ID cannot be null")
    private Integer accountId;

    @NotNull(message = "Service ID cannot be null")
    private Integer serviceId;
}
