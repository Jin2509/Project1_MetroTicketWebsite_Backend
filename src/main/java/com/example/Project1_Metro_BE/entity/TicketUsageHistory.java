package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_usage_history",
        indexes = {
                @Index(name = "idx_ticket_usage_history_ticket", columnList = "ticket_id"),
                @Index(name = "idx_ticket_usage_history_station", columnList = "station_id"),
                @Index(name = "idx_ticket_usage_history_event_time", columnList = "event_time")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketUsageHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_usage_history_ticket"))
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_usage_history_station"))
    private Station station;

    @Column(name = "event_type", nullable = false, length = 20)
    private String eventType;

    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;

    @Column(name = "description", length = 255)
    private String description;
}
