package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.LineStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineStationRepository extends JpaRepository<LineStation, Long> {
}
