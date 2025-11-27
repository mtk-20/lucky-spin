package com.example.lucky_spin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ABL_SPIN_PHONE_NUMBERS")
public class PhoneNumberList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
}
