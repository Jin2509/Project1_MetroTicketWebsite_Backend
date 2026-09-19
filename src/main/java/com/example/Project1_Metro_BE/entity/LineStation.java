package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "line_station",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_line_station", columnNames = {"line_id", "station_id"}),
                @UniqueConstraint(name = "uq_line_station_order", columnNames = {"line_id", "station_order"})
        },
        indexes = {
                @Index(name = "idx_line_station_line", columnList = "line_id"),
                @Index(name = "idx_line_station_station", columnList = "station_id")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false, foreignKey = @ForeignKey(name = "fk_line_station_line"))
    private MetroLine line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false, foreignKey = @ForeignKey(name = "fk_line_station_station"))
    private Station station;

    @Column(name = "station_order", nullable = false)
    private Integer stationOrder;

    @Column(name = "distance_from_prev_km", precision = 8, scale = 3)
    private BigDecimal distanceFromPrevKm;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
