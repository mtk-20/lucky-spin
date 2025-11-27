package com.example.lucky_spin.controller;

import com.example.lucky_spin.common.response.ResponseFactory;
import com.example.lucky_spin.entity.SpinRule;
import com.example.lucky_spin.service.SpinRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rule")
public class SpinRuleController {

    private final SpinRuleService service;
    private final ResponseFactory factory;

    @PostMapping("/create")
    public ResponseEntity<?> handleCreate(@RequestBody SpinRule rule) {
        SpinRule created = service.create(rule);

        return factory.buildSuccess(
                HttpStatus.OK,
                created,
                "201",
                "Rule Created Successfully.");
    }

    @GetMapping("/all")
    public ResponseEntity<?> handleGetAll() {
        List<SpinRule> rules = service.getAll();

        return factory.buildSuccess(
                HttpStatus.OK,
                rules,
                "200",
                "Rules Retrieved.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> handleUpdate(@PathVariable("id") Long id, @RequestBody SpinRule rule) {
        SpinRule updated = service.update(id, rule);

        return factory.buildSuccess(
                HttpStatus.OK,
                updated,
                "200",
                "Rules Updated.");

    }

}
