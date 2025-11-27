package com.example.lucky_spin.repo;

import com.example.lucky_spin.entity.SpinResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface SpinResultRepo extends JpaRepository<SpinResult, Long> {

    boolean findByPhoneNumberAndSpinTimeBetween(String phoneNumber, LocalDateTime start, LocalDateTime end);
}
