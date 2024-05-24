package com.project.DASBackend.repository;

import com.project.DASBackend.entity.CommitmentPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitmentPaperRepository extends JpaRepository<CommitmentPaper, Integer> {
}
