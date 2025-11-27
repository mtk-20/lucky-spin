package com.example.lucky_spin.repo;

import com.example.lucky_spin.entity.Prize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrizeRepo extends JpaRepository<Prize, Long> {

    List<Prize> findByQuantityGreaterThan(int min);

    Optional<Prize> findByPrizeName(String prizeName);

}
