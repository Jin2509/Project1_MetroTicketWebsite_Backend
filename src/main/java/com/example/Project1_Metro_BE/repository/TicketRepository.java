package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByTicketCode(String ticketCode);
}
