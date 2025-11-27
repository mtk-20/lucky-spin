package com.example.lucky_spin.service.impl;

import com.example.lucky_spin.repo.SpinResultRepo;
import com.example.lucky_spin.service.SpinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpinServiceImpl implements SpinService {

    private final SpinResultRepo repo;
}
