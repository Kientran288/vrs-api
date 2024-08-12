package com.vsr.spg.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "visitor",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id", "email"})
        })
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String phoneNumber;
}
