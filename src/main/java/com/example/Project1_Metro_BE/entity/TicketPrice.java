package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_price",
        indexes = {
                @Index(name = "idx_ticket_price_line", columnList = "line_id"),
                @Index(name = "idx_ticket_price_km", columnList = "line_id, from_km, to_km"),
                @Index(name = "idx_ticket_price_period", columnList = "effective_from, effective_to")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_price_line"))
    private MetroLine line;

    @Column(name = "from_km", nullable = false, precision = 8, scale = 2)
    private BigDecimal fromKm;

    @Column(name = "to_km", nullable = false, precision = 8, scale = 2)
    private BigDecimal toKm;

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
