package com.project.DASBackend.service;

import com.project.DASBackend.dto.AccountDto;

import java.util.List;

public interface AccountService{
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Integer accountId);

    List<AccountDto> getAllAccounts();

    AccountDto updateAccount(AccountDto accountDto, Integer accountId);

    void deleteAccount(Integer accountId);

}
