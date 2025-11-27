package com.example.lucky_spin.controller;

import com.example.lucky_spin.common.response.ResponseFactory;
import com.example.lucky_spin.entity.SpinHistory;
import com.example.lucky_spin.service.SpinHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/spin-history")
public class SpinHistoryController {

    private final SpinHistoryService service;
    private final ResponseFactory factory;

    @GetMapping("/all")
    public ResponseEntity<?> handleFindAll() {
        List<SpinHistory> numberLists = service.getAll();

        return factory.buildSuccess(
                HttpStatus.OK,
                numberLists,
                "200",
                "All Spin Records Retrieved.");
    }

    @GetMapping("/id")
    public ResponseEntity<?> handleFindById(@RequestParam Long id) {
        SpinHistory byId = service.getById(id);

        return factory.buildSuccess(
                HttpStatus.OK,
                byId,
                "200",
                "Spin ID " + id + " Retrieved.");
    }

    @GetMapping("/phone")
    public ResponseEntity<?> handleFindByPhoneNumber(@RequestParam String phoneNumber) {
        List<SpinHistory> byPhoneNumber = service.getByPhoneNumber(phoneNumber);

        return factory.buildSuccess(
                HttpStatus.OK,
                byPhoneNumber,
                "200",
                "Phone Number " + phoneNumber + "'s Records Retrieved.");
    }

}
