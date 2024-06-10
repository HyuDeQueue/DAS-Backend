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

                Account account = accountRepository.findByUid(uid);
                if (account == null) {
                    account = Account.builder()
                            .uid(uid)
                            .email(email)
                            .displayName(displayName)
                            .accountStatus(1)
                            .role(1)
                            .build();
                    accountRepository.save(account);
                }

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String sessionId = authentication.getDetails().toString();

                // Return session ID and account details as JSON object
                return ResponseEntity.ok(Map.of(
                        "sessionId", sessionId,
                        "account", account
                ));
            } catch (FirebaseAuthException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error verifying token: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid authorization header.");
        }
    }
}