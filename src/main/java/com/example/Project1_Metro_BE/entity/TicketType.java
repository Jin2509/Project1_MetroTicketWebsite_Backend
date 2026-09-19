package com.example.Project1_Metro_BE.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ticket_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_ticket_type", nullable = false, unique = true, length = 50)
    private String nameTicketType;
}
