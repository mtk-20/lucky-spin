package com.example.lucky_spin.repo;

import com.example.lucky_spin.entity.SpinHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface SpinHistoryRepo extends JpaRepository<SpinHistory, Long> {

    @Query("SELECT COUNT(s) FROM SpinHistory s WHERE s.phoneNumber = :phoneNumber AND DATE(s.spinTime) = :today")
    int countTodaySpins(@Param("phoneNumber") String phoneNumber, @Param("today") LocalDate today);

    List<SpinHistory> findByPhoneNumber(String phoneNumber);

    boolean findByPhoneNumberAndSpinTimeBetween(String phoneNumber, LocalDateTime start, LocalDateTime end);

}
