package com.example.lucky_spin.service;

import com.example.lucky_spin.dto.PrizeUpdateDto;
import com.example.lucky_spin.entity.DailyPrizeLimit;
import com.example.lucky_spin.entity.Prize;

import java.util.List;

public interface PrizeService {

    Prize create(Prize prize);

    List<Prize> getAll();

    Prize getById(Long id);

    List<Prize> gatAllAvailable();

    Prize update(Long id, PrizeUpdateDto dto);

    void delete(Long id);

    DailyPrizeLimit setDailyLimit(Long id, int day, int availableQuantity);

}
