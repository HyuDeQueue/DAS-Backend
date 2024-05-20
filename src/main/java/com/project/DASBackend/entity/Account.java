package com.project.DASBackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Account")
@Data
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_Id")
    private Integer AccountId;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    @Column(name = "IdentityNum", nullable = false, unique = true)
    private String identityNum;

    @Column(name = "Google_access_token", nullable = false)
    private String googleAccessToken;

    @Column(name = "Refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "Access_token_expiry_time", nullable = false)
    private LocalDateTime accessTokenExpiryTime;

    @Column(name = "Account_status", nullable = false)
    private Integer accountStatus;

    @Column(name = "Role", nullable = false)
    private Integer role;
}
