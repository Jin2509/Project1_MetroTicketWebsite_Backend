package com.example.Project1_Metro_BE.entity;

import com.example.Project1_Metro_BE.enums.MessageRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "conversation_message",
        indexes = {
                @Index(name = "idx_conversation_message_conversation", columnList = "conversation_id"),
                @Index(name = "idx_conversation_message_created_at", columnList = "created_at")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConversationMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_id", nullable = false, foreignKey = @ForeignKey(name = "fk_conversation_message_conversation"))
    private Conversation conversation;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private MessageRole role;

    @Column(name = "content", nullable = false, columnDefinition = "text")
    private String content;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
