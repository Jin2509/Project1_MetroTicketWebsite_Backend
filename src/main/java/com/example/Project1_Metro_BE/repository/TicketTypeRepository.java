package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
    Optional<TicketType> findByNameTicketType(String nameTicketType);
}
