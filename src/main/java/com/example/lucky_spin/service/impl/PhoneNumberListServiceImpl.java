package com.example.lucky_spin.service.impl;

import com.example.lucky_spin.common.exception.CommonException;
import com.example.lucky_spin.entity.PhoneNumberList;
import com.example.lucky_spin.repo.PhoneNumberListRepo;
import com.example.lucky_spin.service.PhoneNumberListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneNumberListServiceImpl implements PhoneNumberListService {

    private final PhoneNumberListRepo repo;

    @Override
    public PhoneNumberList create(PhoneNumberList phoneNumberList) {
        return repo.save(phoneNumberList);
    }

    @Override
    public List<PhoneNumberList> getAll() {
        return repo.findAll();
    }

    @Override
    public PhoneNumberList getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new CommonException("ERR_404", "Phone Number ID " + id + " NOT FOUND."));
    }

    @Override
    public PhoneNumberList getByPhoneNumber(String phoneNumber) {
        return repo.findByPhoneNumber(phoneNumber).orElseThrow(() -> new CommonException("ERR_404", "PHONE NUMBER " + phoneNumber + " NOT FOUND."));
    }
}
