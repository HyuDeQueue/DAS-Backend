package com.project.DASBackend.service.impl;

import com.project.DASBackend.dto.AccountDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.mapper.AccountMapper;
import com.project.DASBackend.repository.AccountRepository;
import com.project.DASBackend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto registerOrLoginWithGoogle(AccountDto accountDto) {
        Optional<Account> existingAccount = accountRepository.findByEmail(accountDto.getEmail());

        if (existingAccount.isPresent()) {
            Account account = existingAccount.get();
            account.setGoogleAccessToken(accountDto.getGoogleAccessToken());
            account.setRefreshToken(generateRefreshToken());
            account.setAccessTokenExpiryTime(accountDto.getAccessTokenExpiryTime());
            accountRepository.save(account);
            return AccountMapper.toDto(account);
        } else {
            Account newAccount = AccountMapper.toEntity(accountDto);
            newAccount.setAccountStatus(1);
            newAccount.setRole(1);
            newAccount.setRefreshToken(generateRefreshToken());
            accountRepository.save(newAccount);
            return AccountMapper.toDto(newAccount);
        }
    }

    @Override
    public AccountDto refreshAccessToken(String refreshToken) {
        Optional<Account> accountOptional = accountRepository.findByRefreshToken(refreshToken);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            String newAccessToken = generateNewAccessToken();
            account.setGoogleAccessToken(newAccessToken);
            account.setAccessTokenExpiryTime(LocalDateTime.now().plusHours(2));
            accountRepository.save(account);
            return AccountMapper.toDto(account);
        } else {
            return null;
        }
    }

    private String generateRefreshToken() {
        return UUID.randomUUID().toString();
    }

    private String generateNewAccessToken() {
        return UUID.randomUUID().toString();
    }

}
