package com.project.DASBackend.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDTO {
    private int AccountId;
    private String email;
    private String firstName;
    private String lastName;
    private String identityNum;
    private String googleAccessToken;
    private String refreshToken;
    private LocalDateTime accessTokenExpiryTime;
    private int accountStatus;
    private int role;
}
