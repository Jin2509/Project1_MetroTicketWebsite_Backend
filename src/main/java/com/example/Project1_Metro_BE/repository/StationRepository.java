package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    Optional<Station> findByCode(String code);
}
