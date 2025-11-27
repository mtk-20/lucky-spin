package com.example.lucky_spin.dto;

import lombok.Data;

@Data
public class PrizeUpdateDto {

    private String prizeName;
    private Integer quantity;
    private Integer dropRate;
}
