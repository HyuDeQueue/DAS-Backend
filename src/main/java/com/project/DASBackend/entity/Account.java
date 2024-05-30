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
    private Integer accountId;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Display_name", nullable = false)
    private String displayName;


    @Column(name = "Account_status", nullable = false)
    private Integer accountStatus;

    @Column(name = "Role", nullable = false)
    private Integer role;

}
