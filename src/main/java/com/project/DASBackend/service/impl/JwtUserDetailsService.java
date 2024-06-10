package com.project.DASBackend.service.impl;

import java.util.ArrayList;


import com.project.DASBackend.dto.AccountDto;
import com.project.DASBackend.entity.Account;
import com.project.DASBackend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
JWTUserDetailsService implements the Spring Security UserDetailsService interface.
It overrides the loadUserByUsername for fetching user details from the database using the username.
The Spring Security Authentication Manager calls this method for getting the user details from the database
when authenticating the user details provided by the user. Here we are getting the user details from a hardcoded
User List. In the next tutorial we will be adding the DAO implementation for fetching User Details from the Database.
Also the password for a user is stored in encrypted format using BCrypt.
Previously we have seen Spring Boot Security - Password Encoding Using Bcrypt.
Here using the Online Bcrypt Generator you can generate the Bcrypt for a password.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    @Lazy
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        Account account = accountRepository.findByUid(uid);
        if (account == null) {
            throw new UsernameNotFoundException("User not found with username: " + uid);
        }
        return new org.springframework.security.core.userdetails.User(account.getUid(), "",
                new ArrayList<>());
    }

    public Account save(AccountDto accountDto) {
        Account newAccount = new Account();
        newAccount.setUid(accountDto.getUid());
        //newAccount.setPassword(bcryptEncoder.encode(user.getPassword()));
        return accountRepository.save(newAccount);
    }
}
