package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "operation_config",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_line_version", columnNames = {"line_id", "version"})
        },
        indexes = {
                @Index(name = "idx_operation_config_line", columnList = "line_id"),
                @Index(name = "idx_operation_config_period", columnList = "effective_from, effective_to")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false, foreignKey = @ForeignKey(name = "fk_operation_config_line"))
    private MetroLine line;

    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "number_of_trains", nullable = false)
    private Integer numberOfTrains;

    @Column(name = "headway_minutes", nullable = false)
    private Integer headwayMinutes;

    @Column(name = "running_time_minutes", nullable = false)
    private Integer runningTimeMinutes;

    @Column(name = "turnaround_time_minutes", nullable = false)
    private Integer turnaroundTimeMinutes;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "effective_from", nullable = false)
    private LocalDateTime effectiveFrom;

    @Column(name = "effective_to")
    private LocalDateTime effectiveTo;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
