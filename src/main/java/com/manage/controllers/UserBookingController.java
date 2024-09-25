package com.manage.controllers;

import com.manage.dto.UserBookingsDto;
import com.manage.service.EventService;
import com.manage.service.UserBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookEvent")
@CrossOrigin(origins = "*")
public class UserBookingController {
    @Autowired
    private UserBookingService userBookingService;
    @Autowired
private EventService eventService;
    @PostMapping
    public ResponseEntity<UserBookingsDto> bookATicket(@RequestBody UserBookingsDto userBookingDto) {
        System.out.println(userBookingDto);

        return new ResponseEntity<>(userBookingService.bookTicket(userBookingDto), HttpStatus.OK);
    }
    @GetMapping("/booked/{userId}")
    public List<?> getBookedEvents(@PathVariable String userId) {
        return userBookingService.getUserBookingById(userId);
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<EventDto> getEvent(@PathVariable String id) {
//        return new ResponseEntity<>(eventService.getEventById(id), HttpStatus.OK);
//    }
}
