package com.project.DASBackend.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.repository.AccountRepository;
import com.project.DASBackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> loginWithFirebaseToken(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String idToken = authorizationHeader.substring(7);

            try {
                FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
                String uid = decodedToken.getUid();
                String email = decodedToken.getEmail();
                String displayName = decodedToken.getName();

                Account existingAccount = accountRepository.findByUid(uid);
                if (existingAccount == null) {
                    Account newAccount = Account.builder()
                            .uid(uid)
                            .email(email)
                            .displayName(displayName)
                            .accountStatus(1)
                            .role(1)
                            .build();
                    accountRepository.save(newAccount);
                }

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String sessionId = authentication.getDetails().toString();
                

                // Return session ID as JSON object
                return ResponseEntity.ok(java.util.Map.of("sessionId", sessionId));
            } catch (FirebaseAuthException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error verifying token: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid authorization header.");
        }
    }
}