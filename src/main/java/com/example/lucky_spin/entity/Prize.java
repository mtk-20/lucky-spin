package com.example.lucky_spin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ABL_SPIN_PRIZES")
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRIZE", nullable = false)
    private String prizeName;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "DROP_RATE", nullable = false)
    private Integer dropRate;
}
