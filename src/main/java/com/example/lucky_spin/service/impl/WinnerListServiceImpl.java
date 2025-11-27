package com.example.lucky_spin.service.impl;

import com.example.lucky_spin.common.exception.CommonException;
import com.example.lucky_spin.entity.WinnerList;
import com.example.lucky_spin.repo.WinnerListRepo;
import com.example.lucky_spin.service.WinnerListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WinnerListServiceImpl implements WinnerListService {

    private final WinnerListRepo repo;

    @Override
    public List<WinnerList> getAll() {
        return repo.findAll();
    }

    @Override
    public WinnerList getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new CommonException("ERR_404", "Phone Number ID " + id + " NOT FOUND."));
    }

    @Override
    public List<WinnerList> getByPhoneNumber(String phoneNumber) {
        return repo.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<WinnerList> getByDate(int date) {
        return repo.findByDay(date);
    }
}
