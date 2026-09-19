package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "functions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FunctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_function", nullable = false, unique = true, length = 100)
    private String nameFunction;

    @OneToMany(mappedBy = "functionEntity", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Permission> permissions;
}
