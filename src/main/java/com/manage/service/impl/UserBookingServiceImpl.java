package com.manage.service.impl;

import com.manage.dto.UserBookingsDto;
import com.manage.entities.UserBookings;
import com.manage.repositories.UserBookingRepo;
import com.manage.service.EventService;
import com.manage.service.UserBookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserBookingServiceImpl implements UserBookingService {
    @Autowired
    private UserBookingRepo userBookingRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EventService eventService;

    @Override
    public UserBookingsDto bookTicket(UserBookingsDto userBookingDto) {
//        userBookingDto.setEvent(null);
        return modelMapper.map(userBookingRepo.save(modelMapper.map(userBookingDto, UserBookings.class)), UserBookingsDto.class);
    }

    @Override
    public List<UserBookingsDto> getUserBookingById(String userId) {
        List<UserBookingsDto> list = this.userBookingRepo.findByUserId(userId).stream().map(userBookings -> modelMapper.map(userBookings, UserBookingsDto.class)).collect(Collectors.toList());
        list.forEach(userBookingsDto -> {
            if (userBookingsDto.getEventId()!= null) {
                userBookingsDto.setEventdto(eventService.getEventById(userBookingsDto.getEventId()));
            }
        });
        return list;
    }

}
