package com.example.lucky_spin.controller;

import com.example.lucky_spin.common.response.ResponseFactory;
import com.example.lucky_spin.entity.PhoneNumberList;
import com.example.lucky_spin.service.PhoneNumberListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phone-number-list")
public class PhoneNumberListController {

    private final PhoneNumberListService service;
    private final ResponseFactory factory;

    @PostMapping("/create")
    public ResponseEntity<?> handleCreate(@RequestBody PhoneNumberList phoneNumberList) {
        PhoneNumberList created = service.create(phoneNumberList);

        return factory.buildSuccess(
                HttpStatus.OK,
                created,
                "201",
                "Phone Number Added Successfully.");
    }

    @GetMapping("/all")
    public ResponseEntity<?> handleFindAll() {
        List<PhoneNumberList> numberLists = service.getAll();

        return factory.buildSuccess(
                HttpStatus.OK,
                numberLists,
                "200",
                "All Phone Number Retrieved.");
    }

    @GetMapping("/id")
    public ResponseEntity<?> handleFindById(@RequestParam Long id) {
        PhoneNumberList byId = service.getById(id);

        return factory.buildSuccess(
                HttpStatus.OK,
                byId,
                "200",
                "Phone Number ID " + id + " Retrieved.");
    }

    @GetMapping("/phone")
    public ResponseEntity<?> handleFindByPhoneNumber(@RequestParam String phoneNumber) {
        PhoneNumberList byPhoneNumber = service.getByPhoneNumber(phoneNumber);

        return factory.buildSuccess(
                HttpStatus.OK,
                byPhoneNumber,
                "200",
                "Phone Number " + phoneNumber + " Retrieved.");
    }

}
