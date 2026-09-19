package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permission",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_permission", columnNames = {"role_id", "function_id", "permission"})
        },
        indexes = {
                @Index(name = "idx_permission_role", columnList = "role_id"),
                @Index(name = "idx_permission_function", columnList = "function_id")
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_permission_role"))
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "function_id", nullable = false, foreignKey = @ForeignKey(name = "fk_permission_function"))
    private FunctionEntity functionEntity;

    @Column(name = "permission", nullable = false, length = 30)
    private String permission;
}
