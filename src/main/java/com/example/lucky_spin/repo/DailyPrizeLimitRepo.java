package com.example.lucky_spin.repo;

import com.example.lucky_spin.entity.DailyPrizeLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DailyPrizeLimitRepo extends JpaRepository<DailyPrizeLimit, Long> {

    List<DailyPrizeLimit> findByDay(int day);

    @Query("SELECT q FROM DailyPrizeLimit q WHERE q.day = :day AND q.prize.id = :prizeId")
    Optional<DailyPrizeLimit> findByDayAndPrizeId(@Param("day") int day, @Param("prizeId") Long prizeId);

}
