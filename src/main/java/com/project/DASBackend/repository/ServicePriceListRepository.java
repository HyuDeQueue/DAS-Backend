package com.project.DASBackend.repository;

import com.project.DASBackend.entity.ServicePriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePriceListRepository extends JpaRepository<ServicePriceList, Integer> {
}
