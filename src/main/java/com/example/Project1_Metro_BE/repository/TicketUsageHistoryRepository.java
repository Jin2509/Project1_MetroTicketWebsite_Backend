package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.TicketUsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketUsageHistoryRepository extends JpaRepository<TicketUsageHistory, Long> {
}
