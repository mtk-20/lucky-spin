package com.example.lucky_spin.service.impl;

import com.example.lucky_spin.common.exception.CommonException;
import com.example.lucky_spin.entity.SpinRule;
import com.example.lucky_spin.repo.SpinRuleRepo;
import com.example.lucky_spin.service.SpinRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpinRuleServiceImpl implements SpinRuleService {

    private final SpinRuleRepo repo;

    @Override
    public int getInt(String key) {
        return repo.findByRuleKey(key)
                .map(r -> Integer.parseInt(r.getRuleValue()))
                .orElseThrow(() -> new CommonException("ERR_404", "Rule not found: " + key));
    }

    @Override
    public SpinRule create(SpinRule rule) {
        if ("max_spins_per_day".equals(rule.getRuleKey())) {
            int value = Integer.parseInt(rule.getRuleValue());
            if (value <= 0)
                throw new CommonException("ERR_400", "MAX_SPIN_PER_DAY_MUST_BE_POSITIVE.");
        }
        return repo.save(rule);
    }

    @Override
    public List<SpinRule> getAll() {
        return repo.findAll();
    }

    @Override
    public SpinRule update(Long id, SpinRule rule) {
        SpinRule updated = repo.findById(id).orElseThrow(() -> new CommonException("ERR_404", "ID not found: " + id));
        if ("max_spins_per_day".equals(rule.getRuleKey())) {
            int value = Integer.parseInt(rule.getRuleValue());
            if (value <= 0)
                throw new CommonException("ERR_400", "MAX_SPIN_PER_DAY_MUST_BE_POSITIVE.");
        }
        updated.setRuleKey(rule.getRuleKey());
        updated.setRuleValue(rule.getRuleValue());
        return repo.save(updated);
    }
}
