package com.example.lucky_spin.controller;

import com.example.lucky_spin.common.response.ResponseFactory;
import com.example.lucky_spin.dto.SpinResultDto;
import com.example.lucky_spin.service.SpinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/spin")
public class SpinController {

    private final SpinService service;
    private final ResponseFactory factory;

    @PostMapping
    public ResponseEntity<?> handleSpin(@RequestBody Map<String, String> request) {
        String phone = request.get("phoneNumber");
        if (phone == null || phone.isEmpty()) {
            return ResponseEntity.badRequest().body(SpinResultDto.error("Phone_Required!"));
        }
        SpinResultDto result = service.spin(phone);
        return factory.buildSuccess(
                HttpStatus.OK,
                result,
                "201",
                "Spin Success.");
    }


}
