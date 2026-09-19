package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    Optional<Train> findByCode(String code);
}
