package com.project.DASBackend.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommitmentPaperDto {
    private Integer commitmentId;
    private LocalDateTime dateCreated;
    private LocalDateTime approvalDate;
    private String commitmentType;
    private String description;
    private Integer bookingId;
    private Integer accountId;
}
