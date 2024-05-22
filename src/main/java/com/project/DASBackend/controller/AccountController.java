package com.project.DASBackend.controller;

import com.project.DASBackend.dto.AccountDto;
import com.project.DASBackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/google")
    public AccountDto registerOrLoginWithGoogle(@RequestBody AccountDto accountDto) {
        return accountService.registerOrLoginWithGoogle(accountDto);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AccountDto> refreshAccessToken(@RequestBody String refreshToken) {
        AccountDto accountDto = accountService.refreshAccessToken(refreshToken);
        if (accountDto != null) {
            return ResponseEntity.ok(accountDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
