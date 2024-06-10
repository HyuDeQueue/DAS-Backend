package com.project.DASBackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.DASBackend.entity.Account;
import com.project.DASBackend.repository.AccountRepository;

import java.util.ArrayList;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        Account account = accountRepository.findByUid(uid);
        if (account == null) {
            throw new UsernameNotFoundException("User not found with UID: " + uid);
        }
        return new org.springframework.security.core.userdetails.User(account.getUid(), "", new ArrayList<>());
    }
}
