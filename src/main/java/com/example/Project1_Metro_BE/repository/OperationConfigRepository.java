package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.OperationConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationConfigRepository extends JpaRepository<OperationConfig, Long> {
}
