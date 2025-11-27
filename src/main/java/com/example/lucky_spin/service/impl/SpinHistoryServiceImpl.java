package com.example.lucky_spin.service.impl;

import com.example.lucky_spin.common.exception.CommonException;
import com.example.lucky_spin.entity.SpinHistory;
import com.example.lucky_spin.repo.SpinHistoryRepo;
import com.example.lucky_spin.service.SpinHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpinHistoryServiceImpl implements SpinHistoryService {

    private final SpinHistoryRepo repo;

    @Override
    public List<SpinHistory> getAll() {
        return repo.findAll();
    }

    @Override
    public SpinHistory getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new CommonException("ERR_404", "Phone Number ID " + id + " NOT FOUND."));
    }

    @Override
    public List<SpinHistory> getByPhoneNumber(String phoneNumber) {
        return repo.findByPhoneNumber(phoneNumber);
    }
}
