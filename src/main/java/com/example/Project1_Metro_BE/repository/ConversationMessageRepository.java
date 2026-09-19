package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.ConversationMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationMessageRepository extends JpaRepository<ConversationMessage, Long> {
    List<ConversationMessage> findByConversationIdOrderByCreatedAtAsc(Long conversationId);
}
