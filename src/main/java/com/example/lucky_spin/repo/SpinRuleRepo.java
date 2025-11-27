package com.example.lucky_spin.repo;

import com.example.lucky_spin.entity.SpinRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpinRuleRepo extends JpaRepository<SpinRule, Long> {

    Optional<SpinRule> findByRuleKey(String key);

}
