package com.project.DASBackend.repository;

import com.project.DASBackend.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
