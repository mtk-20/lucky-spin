package com.example.lucky_spin.service;

import com.example.lucky_spin.dto.SpinResultDto;

public interface SpinService {

    SpinResultDto spin(String phoneNumber);
}
