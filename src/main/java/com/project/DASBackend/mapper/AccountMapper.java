package com.project.DASBackend.mapper;

import com.project.DASBackend.dto.AccountDto;
import com.project.DASBackend.entity.Account;

public class AccountMapper {
    public static AccountDto toDto(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountDto(
                account.getAccountId(),
                account.getEmail(),
                account.getFirstName(),
                account.getLastName(),
                account.getGoogleAccessToken(),
                account.getRefreshToken(),
                account.getAccessTokenExpiryTime(),
                account.getAccountStatus(),
                account.getRole()
        );
    }

    public static Account toEntity(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }
        Account account = new Account();
        account.setAccountId(accountDto.getAccountId());
        account.setEmail(accountDto.getEmail());
        account.setFirstName(accountDto.getFirstName());
        account.setLastName(accountDto.getLastName());
        account.setGoogleAccessToken(accountDto.getGoogleAccessToken());
        account.setRefreshToken(accountDto.getRefreshToken());
        account.setAccessTokenExpiryTime(accountDto.getAccessTokenExpiryTime());
        account.setAccountStatus(accountDto.getAccountStatus());
        account.setRole(accountDto.getRole());
        return account;
    }
}
