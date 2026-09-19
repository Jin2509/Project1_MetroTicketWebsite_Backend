package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket",
        indexes = {
                @Index(name = "idx_ticket_user", columnList = "user_id"),
                @Index(name = "idx_ticket_type", columnList = "ticket_type_id"),
                @Index(name = "idx_ticket_line", columnList = "line_id"),
                @Index(name = "idx_ticket_departure_station", columnList = "departure_station_id"),
                @Index(name = "idx_ticket_arrival_station", columnList = "arrival_station_id"),
                @Index(name = "idx_ticket_status", columnList = "status"),
                @Index(name = "idx_ticket_purchased_at", columnList = "purchased_at"),
                @Index(name = "idx_ticket_validity", columnList = "effective_from, effective_to")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticket_code", nullable = false, unique = true, length = 50)
    private String ticketCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_ticket_user"))
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_type"))
    private TicketType ticketType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_line"))
    private MetroLine line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_station_id", foreignKey = @ForeignKey(name = "fk_ticket_departure_station"))
    private Station departureStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_station_id", foreignKey = @ForeignKey(name = "fk_ticket_arrival_station"))
    private Station arrivalStation;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "ticket_token", unique = true, length = 255)
    private String ticketToken;

    @Column(name = "purchased_at", nullable = false)
    private LocalDateTime purchasedAt;

    @Column(name = "effective_from")
    private LocalDateTime effectiveFrom;

    @Column(name = "effective_to")
    private LocalDateTime effectiveTo;

    @Column(name = "status", nullable = false, length = 30)
    private String status;
}
