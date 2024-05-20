package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AccountDto;
import com.project.DASBackend.entity.Account;

public class AccountMapper {
    public static AccountDto toDto(Account account) {
        if (account == null) {
            return null;
        }

        AccountDto dto = new AccountDto();
        dto.setAccountId(account.getAccountId());
        dto.setAccessTokenExpiryTime(account.getAccessTokenExpiryTime());
        dto.setAccountStatus(account.getAccountStatus());
        dto.setEmail(account.getEmail());
        dto.setFirstName(account.getFirstName());
        dto.setGoogleAccessToken(account.getGoogleAccessToken());
        dto.setIdentityNum(account.getIdentityNum());
        dto.setLastName(account.getLastName());
        dto.setRefreshToken(account.getRefreshToken());
        dto.setRole(account.getRole());

        return dto;
    }

    public static Account toEntity(AccountDto dto) {
        if (dto == null) {
            return null;
        }

        Account account = new Account();
        account.setAccountId(dto.getAccountId());
        account.setAccessTokenExpiryTime(dto.getAccessTokenExpiryTime());
        account.setAccountStatus(dto.getAccountStatus());
        account.setEmail(dto.getEmail());
        account.setFirstName(dto.getFirstName());
        account.setGoogleAccessToken(dto.getGoogleAccessToken());
        account.setIdentityNum(dto.getIdentityNum());
        account.setLastName(dto.getLastName());
        account.setRefreshToken(dto.getRefreshToken());
        account.setRole(dto.getRole());

        return account;
    }
}
