package com.example.lucky_spin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ABL_SPIN_HISTORY")
public class SpinHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

//    @Column(name = "PRIZE_NAME")
//    private String prizeName;

    @Column(name = "DAY")
    private Integer day;

    @Column(name = "SPIN_TIME")
    private LocalDateTime spinTime;

    @Column(name = "PRIZE")
    private String prize;
}
