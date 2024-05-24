package com.project.DASBackend.repository;

import com.project.DASBackend.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer> {
}
