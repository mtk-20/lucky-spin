package com.example.lucky_spin.service;

import com.example.lucky_spin.entity.SpinHistory;

import java.util.List;

public interface SpinHistoryService {

    List<SpinHistory> getAll();

    SpinHistory getById(Long id);

    List<SpinHistory> getByPhoneNumber(String phoneNumber);

}
