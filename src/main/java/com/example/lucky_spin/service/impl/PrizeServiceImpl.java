package com.example.lucky_spin.service.impl;

import com.example.lucky_spin.common.exception.CommonException;
import com.example.lucky_spin.dto.PrizeUpdateDto;
import com.example.lucky_spin.entity.DailyPrizeLimit;
import com.example.lucky_spin.entity.Prize;
import com.example.lucky_spin.repo.DailyPrizeLimitRepo;
import com.example.lucky_spin.repo.PrizeRepo;
import com.example.lucky_spin.service.PrizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrizeServiceImpl implements PrizeService {

    private final PrizeRepo repo;
    private final DailyPrizeLimitRepo limitRepo;

    @Override
    public Prize create(Prize prize) {
        return repo.save(prize);
    }

    @Override
    public List<Prize> getAll() {
        return repo.findAll();
    }

    @Override
    public Prize getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new CommonException("ERR_404", "Prize ID " + id + " Not Found."));
    }

    @Override
    public List<Prize> gatAllAvailable() {
        return repo.findByQuantityGreaterThan(0);
    }

    @Override
    public Prize update(Long id, PrizeUpdateDto dto) {
        Prize prize = repo.findById(id).orElseThrow(() -> new CommonException("ERR_404", "Prize ID " + id + " Not Found."));
        prize.setPrizeName(dto.getPrizeName());
        prize.setQuantity(dto.getQuantity());
//        prize.setDropRate(dto.getDropRate());
        return repo.save(prize);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new CommonException("ERR_404", "Prize ID " + id + " Not Found.");
        }
        repo.deleteById(id);
    }

    @Override
    public DailyPrizeLimit setDailyLimit(Long id, int day, int availableQuantity) {
        Prize prize = repo.findById(id).orElseThrow(() -> new CommonException("ERR_404", "Prize ID " + id + " Not Found."));
        DailyPrizeLimit limit = limitRepo.findByDayAndPrizeId(day, id).orElse(new DailyPrizeLimit());
        limit.setDay(day);
        limit.setAvailableQuantity(availableQuantity);
        limit.setPrize(prize);
        return limitRepo.save(limit);
    }

    @Transactional
    public void decrementQuantity(Prize prize) {
        if (prize.getQuantity() > 0) {
            prize.setQuantity(prize.getQuantity() - 1);
            repo.save(prize);
        }
    }
}
