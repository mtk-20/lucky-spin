package com.example.lucky_spin.service;

import com.example.lucky_spin.entity.PhoneNumberList;

import java.util.List;

public interface PhoneNumberListService {

    PhoneNumberList create(PhoneNumberList phoneNumberList);

    List<PhoneNumberList> getAll();

    PhoneNumberList getById(Long id);

    PhoneNumberList getByPhoneNumber(String phoneNumber);

}
