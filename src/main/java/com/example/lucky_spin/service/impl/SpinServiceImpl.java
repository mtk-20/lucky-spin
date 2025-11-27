package com.example.lucky_spin.service.impl;

import com.example.lucky_spin.dto.SpinResultDto;
import com.example.lucky_spin.entity.DailyPrizeLimit;
import com.example.lucky_spin.entity.Prize;
import com.example.lucky_spin.entity.SpinHistory;
import com.example.lucky_spin.entity.WinnerList;
import com.example.lucky_spin.repo.DailyPrizeLimitRepo;
import com.example.lucky_spin.repo.SpinHistoryRepo;
import com.example.lucky_spin.repo.WinnerListRepo;
import com.example.lucky_spin.service.SpinRuleService;
import com.example.lucky_spin.service.SpinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpinServiceImpl implements SpinService {

    private final SpinRuleService service;
    private final DailyPrizeLimitRepo dailyPrizeLimitRepo;
    private final SpinHistoryRepo spinHistoryRepo;
    private final WinnerListRepo winnerListRepo;

    @Override
    @Transactional
    public SpinResultDto spin(String phoneNumber) {

        LocalDate today = LocalDate.now();
        int dayNumber = getEventDay(today);

        if (dayNumber == -1) {
            return SpinResultDto.error("EVENT_COMPLETED.");
        }

        int maxSpinsPerDay = service.getInt("max_spins_per_day");

        if (maxSpinsPerDay <= 0) {
            return SpinResultDto.error("SPIN_DISABLED");
        }

        int usedSpins = spinHistoryRepo.countTodaySpins(phoneNumber, today);

        if (usedSpins >= maxSpinsPerDay) {
            return SpinResultDto.error("SPIN_LIMIT_REACHED");
        }

        List<DailyPrizeLimit> limits = dailyPrizeLimitRepo.findByDay(dayNumber);

        List<DailyPrizeLimit> availableToday = limits.stream()
                .filter(l -> l.getAvailableQuantity() > 0)
                .collect(Collectors.toList());

        if (availableToday.isEmpty()) {
            return SpinResultDto.error("NO_PRIZES_LEFT");
        }

        DailyPrizeLimit randomPrize = pickRandomPrize(availableToday);

        randomPrize.setAvailableQuantity(randomPrize.getAvailableQuantity() - 1);
        dailyPrizeLimitRepo.save(randomPrize);

        Prize prize = randomPrize.getPrize();

        SpinHistory history = new SpinHistory();
        history.setPhoneNumber(phoneNumber);
        history.setDay(dayNumber);
        history.setSpinTime(LocalDateTime.now());
        history.setPrize(prize.getPrizeName());
        spinHistoryRepo.save(history);

        WinnerList winner = new WinnerList();
        winner.setPhoneNumber(phoneNumber);
        winner.setPrize(prize);
        winner.setDay(dayNumber);
        winner.setSpinTime(LocalDateTime.now());
        winnerListRepo.save(winner);

        return SpinResultDto.success(prize.getPrizeName());
    }

    private DailyPrizeLimit pickRandomPrize(List<DailyPrizeLimit> available) {
        Random r = new Random();
        return available.get(r.nextInt(available.size()));
    }

    private int getEventDay(LocalDate today) {
        LocalDate day1 = LocalDate.of(2025, 11, 27);
        LocalDate day2 = day1.plusDays(1);
        LocalDate day3 = day1.plusDays(2);
        if (today.isEqual(day1)) return 1;
        if (today.isEqual(day2)) return 2;
        if (today.isEqual(day3)) return 3;
        return -1;
    }
}