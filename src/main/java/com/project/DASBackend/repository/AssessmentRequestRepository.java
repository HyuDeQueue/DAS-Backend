package com.project.DASBackend.repository;

import com.project.DASBackend.entity.AssessmentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRequestRepository extends JpaRepository<AssessmentRequest, Integer> {
}
