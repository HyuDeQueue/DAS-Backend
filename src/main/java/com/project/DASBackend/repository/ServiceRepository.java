package com.project.DASBackend.repository;

import com.project.DASBackend.entity.Services;
import com.project.DASBackend.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Integer> {
}
