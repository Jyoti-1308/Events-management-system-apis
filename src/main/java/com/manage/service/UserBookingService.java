package com.manage.service;

import com.manage.dto.UserBookingsDto;

import java.util.List;

public interface UserBookingService {
    UserBookingsDto bookTicket(UserBookingsDto userBookingDto);
    List<UserBookingsDto> getUserBookingById(String userId);
}
