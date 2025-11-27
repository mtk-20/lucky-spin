package com.example.lucky_spin.repo;

import com.example.lucky_spin.entity.PhoneNumberList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneNumberListRepo extends JpaRepository<PhoneNumberList, Long> {

    Optional<PhoneNumberList> findByPhoneNumber(String phoneNumber);
}
