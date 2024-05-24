package com.project.DASBackend.repository;

import com.project.DASBackend.entity.AssessmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentBookingRepository extends JpaRepository<AssessmentBooking, Integer> {
}
