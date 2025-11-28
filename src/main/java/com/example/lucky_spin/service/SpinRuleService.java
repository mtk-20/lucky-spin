package com.example.lucky_spin.service;

import com.example.lucky_spin.entity.SpinRule;

import java.time.LocalDate;
import java.util.List;

public interface SpinRuleService {

    int getInt(String key);

    LocalDate getDate(String key);

    SpinRule create(SpinRule rule);

    List<SpinRule> getAll();

    SpinRule update(Long id, SpinRule rule);
}
