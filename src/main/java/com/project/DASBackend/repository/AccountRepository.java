package com.project.DASBackend.repository;

import com.project.DASBackend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Integer> {
}
