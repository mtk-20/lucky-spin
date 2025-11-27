package com.example.lucky_spin.controller;

import com.example.lucky_spin.common.response.ResponseFactory;
import com.example.lucky_spin.entity.WinnerList;
import com.example.lucky_spin.service.WinnerListService;
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
@RequestMapping("/winner-list")
public class WinnerListController {

    private final WinnerListService service;
    private final ResponseFactory factory;

    @GetMapping("/all")
    public ResponseEntity<?> handleFindAll() {
        List<WinnerList> serviceAll = service.getAll();

        return factory.buildSuccess(
                HttpStatus.OK,
                serviceAll,
                "200",
                "All Winners Retrieved.");
    }

    @GetMapping("/id")
    public ResponseEntity<?> handleFindById(@RequestParam Long id) {
        WinnerList byId = service.getById(id);

        return factory.buildSuccess(
                HttpStatus.OK,
                byId,
                "200",
                "Winner ID " + id + " Retrieved.");
    }

    @GetMapping("/phone")
    public ResponseEntity<?> handleFindByPhoneNumber(@RequestParam String phoneNumber) {
        List<WinnerList> byPhoneNumber = service.getByPhoneNumber(phoneNumber);

        return factory.buildSuccess(
                HttpStatus.OK,
                byPhoneNumber,
                "200",
                "Winner With " + phoneNumber + "'s Records Retrieved.");
    }

    @GetMapping("/date")
    public ResponseEntity<?> handleFindByDate(@RequestParam int date) {
        List<WinnerList> byDate = service.getByDate(date);

        return factory.buildSuccess(
                HttpStatus.OK,
                byDate,
                "200",
                "Winner At " + date + " Records Retrieved.");
    }
}
