package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.LineTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineTransferRepository extends JpaRepository<LineTransfer, Long> {
}
