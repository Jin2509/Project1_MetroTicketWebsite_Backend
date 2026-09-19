package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.FunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FunctionRepository extends JpaRepository<FunctionEntity, Long> {
    Optional<FunctionEntity> findByNameFunction(String nameFunction);
}
