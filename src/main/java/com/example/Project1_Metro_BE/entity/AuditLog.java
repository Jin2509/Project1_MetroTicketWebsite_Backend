package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log",
        indexes = {
                @Index(name = "idx_audit_log_user", columnList = "user_id"),
                @Index(name = "idx_audit_log_event_time", columnList = "event_time"),
                @Index(name = "idx_audit_log_table_name", columnList = "table_name, record_id")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_audit_log_user"))
    private Users user;

    @Column(name = "action", nullable = false, length = 50)
    private String action;

    @Column(name = "table_name", length = 100)
    private String tableName;

    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;
}
