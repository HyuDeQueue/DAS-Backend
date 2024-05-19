package com.project.DASBackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentRequestDTO {
    private int requestId;
    private String phone;
    private int numberOfDiamonds;
    private LocalDateTime dateCreated;
    private LocalDateTime meetingDate;
    private String address;
    private int accountId;
    private int serviceId;
}
