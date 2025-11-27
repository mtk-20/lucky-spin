package com.example.lucky_spin.service;

import com.example.lucky_spin.entity.WinnerList;

import java.time.LocalDateTime;
import java.util.List;

public interface WinnerListService {

    List<WinnerList> getAll();

    WinnerList getById(Long id);

    List<WinnerList> getByPhoneNumber(String phoneNumber);

    List<WinnerList> getByDate(int date);
}
