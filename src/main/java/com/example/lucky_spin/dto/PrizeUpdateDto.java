package com.example.lucky_spin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrizeUpdateDto {

    private String prizeName;
    private Integer quantity;
//    private Integer dropRate;
}
