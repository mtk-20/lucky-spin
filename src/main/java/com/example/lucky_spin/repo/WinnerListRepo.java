package com.example.lucky_spin.repo;

import com.example.lucky_spin.entity.WinnerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WinnerListRepo extends JpaRepository<WinnerList, Long> {

    List<WinnerList> findByPhoneNumber(String phoneNumber);

    @Query("SELECT w FROM WinnerList w where w.day = :day")
    List<WinnerList> findByDay(@Param("day") int day);

}
