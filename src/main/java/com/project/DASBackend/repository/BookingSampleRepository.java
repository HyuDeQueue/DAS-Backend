package com.project.DASBackend.repository;

import com.project.DASBackend.entity.BookingSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingSampleRepository extends JpaRepository<BookingSample, Integer> {
    List<BookingSample> findByBookingBookingId(Integer bookingId);
}
