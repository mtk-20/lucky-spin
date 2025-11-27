package com.example.lucky_spin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpinResultDto {

    private boolean success;
    private String prizeName;
    private String message;

    public static SpinResultDto success(String prize) {
        return new SpinResultDto(true, prize, "Congratulation. You Won " + prize.toUpperCase());
    }

    public static SpinResultDto error(String message) {
        return new SpinResultDto(false, null, message);
    }
}
