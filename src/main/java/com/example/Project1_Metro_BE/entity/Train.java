package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "train",
        indexes = {
                @Index(name = "idx_train_line", columnList = "line_id"),
                @Index(name = "idx_train_status", columnList = "status")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 30)
    private String code;

    @Column(name = "name_train", length = 100)
    private String nameTrain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", foreignKey = @ForeignKey(name = "fk_train_line"))
    private MetroLine line;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
