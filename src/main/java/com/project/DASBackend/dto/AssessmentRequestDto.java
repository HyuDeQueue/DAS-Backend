package com.project.DASBackend.dto;

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
    private Integer requestId;
    private String phone;
    private Integer numberOfDiamonds;
    private LocalDateTime dateCreated;
    private LocalDateTime meetingDate;
    private String address;
    private Integer accountId;
    private Integer serviceId;
}
