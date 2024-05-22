package com.project.DASBackend.service;

import com.project.DASBackend.dto.AccountDto;

public interface AccountService{
    AccountDto registerOrLoginWithGoogle(AccountDto accountDto);
    AccountDto refreshAccessToken(String refreshToken);
}
