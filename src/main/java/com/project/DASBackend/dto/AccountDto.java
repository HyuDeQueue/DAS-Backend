package com.project.DASBackend.dto;

import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto {

    @NotNull(message = "Account ID cannot be null")
    private Integer accountId;

    @NotBlank(message = "UID cannot be blank")
    private String uid;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Display name cannot be blank")
    private String displayName;

    @NotNull(message = "Account status cannot be null")
    private Integer accountStatus;

    @NotNull(message = "Role cannot be null")
    private Integer role;
}
