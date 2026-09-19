package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.PeriodicTicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodicTicketPriceRepository extends JpaRepository<PeriodicTicketPrice, Long> {
}
