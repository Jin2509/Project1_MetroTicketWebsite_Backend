package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByTransactionCode(String transactionCode);
}
