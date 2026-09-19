package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "periodic_ticket_price",
        indexes = {
                @Index(name = "idx_periodic_ticket_price_type", columnList = "ticket_type_id"),
                @Index(name = "idx_periodic_ticket_price_period", columnList = "effective_from, effective_to")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeriodicTicketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id", nullable = false, foreignKey = @ForeignKey(name = "fk_periodic_ticket_price_type"))
    private TicketType ticketType;

    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(name = "effective_from", nullable = false)
    private LocalDateTime effectiveFrom;

    @Column(name = "effective_to")
    private LocalDateTime effectiveTo;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
