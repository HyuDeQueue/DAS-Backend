package com.project.DASBackend.repository;

import com.project.DASBackend.entity.AssessmentPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentPaperRepository extends JpaRepository<AssessmentPaper, Integer> {
}
