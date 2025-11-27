package com.example.lucky_spin.controller;

import com.example.lucky_spin.common.response.ResponseFactory;
import com.example.lucky_spin.dto.PrizeUpdateDto;
import com.example.lucky_spin.entity.DailyPrizeLimit;
import com.example.lucky_spin.entity.Prize;
import com.example.lucky_spin.service.PrizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prize")
public class PrizeController {

    private final PrizeService service;
    private final ResponseFactory factory;

    @PostMapping("/create")
    public ResponseEntity<?> handleCreate(@RequestBody Prize prize) {
        Prize created = service.create(prize);

        return factory.buildSuccess(
                HttpStatus.OK,
                created,
                "201",
                "Prize Added Successfully.");
    }

    @GetMapping("/all")
    public ResponseEntity<?> handleFindAll() {
        List<Prize> prizes = service.getAll();

        return factory.buildSuccess(
                HttpStatus.OK,
                prizes,
                "200",
                "All Prizes Retrieved.");
    }

    @GetMapping("/id")
    public ResponseEntity<?> handleFindById(@RequestParam Long id) {
        Prize byId = service.getById(id);

        return factory.buildSuccess(
                HttpStatus.OK,
                byId,
                "200",
                "Prize ID " + id + " Retrieved.");
    }

    @GetMapping("/available")
    public ResponseEntity<?> handleFindAvailable() {
        List<Prize> available = service.gatAllAvailable();

        return factory.buildSuccess(
                HttpStatus.OK,
                available,
                "200",
                "Prize " + available.size() + " Available.");
    }

    @PutMapping("/update")
    public ResponseEntity<?> handleUpdate(@RequestParam Long id, @RequestBody PrizeUpdateDto dto) {
        Prize updated = service.update(id, dto);

        return factory.buildSuccess(
                HttpStatus.OK,
                updated,
                "200",
                "Prize ID " + id + " Updated.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> handleDelete(@RequestParam Long id) {
         service.delete(id);

        return factory.buildSuccess(
                HttpStatus.OK,
                null,
                "204",
                "Prize " + id + " Deleted.");
    }

    @PostMapping("/limit/{id}")
    public ResponseEntity<?> handleSetDailyLimit(@PathVariable("id") Long id, @RequestParam int day, @RequestParam int availableQuantity) {
        DailyPrizeLimit limit = service.setDailyLimit(id, day, availableQuantity);

        return factory.buildSuccess(
                HttpStatus.OK,
                limit,
                "200",
                "Daily Limit Set.");
    }

}
