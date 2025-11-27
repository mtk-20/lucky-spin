package com.example.lucky_spin.repo;

import com.example.lucky_spin.entity.Prize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrizeRepo extends JpaRepository<Prize, Long> {

    List<Prize> findByQuantityGraterThan(int min);
}
