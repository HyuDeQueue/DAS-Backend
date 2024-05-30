package com.project.DASBackend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto {
    private Integer accountId;
    private String email;
    private String displayName;
    private Integer accountStatus;
    private Integer role;
}
