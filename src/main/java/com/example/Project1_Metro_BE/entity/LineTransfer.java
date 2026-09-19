package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "line_transfer",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_line_transfer", columnNames = {"station_id", "from_line_id", "to_line_id"})
        },
        indexes = {
                @Index(name = "idx_line_transfer_station", columnList = "station_id"),
                @Index(name = "idx_line_transfer_from_line", columnList = "from_line_id"),
                @Index(name = "idx_line_transfer_to_line", columnList = "to_line_id")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false, foreignKey = @ForeignKey(name = "fk_line_transfer_station"))
    private Station station;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_line_id", nullable = false, foreignKey = @ForeignKey(name = "fk_line_transfer_from_line"))
    private MetroLine fromLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_line_id", nullable = false, foreignKey = @ForeignKey(name = "fk_line_transfer_to_line"))
    private MetroLine toLine;

    @Column(name = "transfer_time_minutes", nullable = false)
    private Integer transferTimeMinutes;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
