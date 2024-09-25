package com.manage.repositories;

import com.manage.entities.UserBookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookingRepo extends JpaRepository<UserBookings,Integer> {
    List<UserBookings> findByUserId(String userId);
}
