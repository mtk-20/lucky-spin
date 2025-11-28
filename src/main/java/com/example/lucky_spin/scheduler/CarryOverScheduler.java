package com.example.lucky_spin.scheduler;

import com.example.lucky_spin.entity.DailyPrizeLimit;
import com.example.lucky_spin.repo.DailyPrizeLimitRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarryOverScheduler {

    private final DailyPrizeLimitRepo repo;

    @Scheduled(cron = "0 0 0 * * ?")
//    @Scheduled(fixedRate = 3000000)
    public void carryOverRemainingPrizes() {
        for (int day = 1; day <= 2; day++) {
            List<DailyPrizeLimit> todayLimits = repo.findByDay(day);
            List<DailyPrizeLimit> nextDayLimits = repo.findByDay(day + 1);
            for (DailyPrizeLimit qToday : todayLimits) {
                DailyPrizeLimit nextDay = nextDayLimits.stream()
                        .filter(q -> q.getPrize().getId().equals(qToday.getPrize().getId()))
                        .findFirst().orElse(null);
                if (nextDay != null) {
                    nextDay.setAvailableQuantity(nextDay.getAvailableQuantity() + qToday.getAvailableQuantity());
                    repo.save(nextDay);
                }
                qToday.setAvailableQuantity(0);
                repo.save(qToday);
            }
        }
    }
}
