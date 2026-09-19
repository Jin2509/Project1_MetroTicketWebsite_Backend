package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.MetroLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetroLineRepository extends JpaRepository<MetroLine, Long> {
    Optional<MetroLine> findByCode(String code);
}
