package com.manage.controllers;


import com.manage.dto.EventDto;

import com.manage.entities.Event;
import com.manage.payloads.ApiResponse;
import com.manage.payloads.PageableResponse;

import com.manage.service.EventService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")
public class EventsController {
    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventDto> createAnEvent(@RequestBody EventDto eventDto) {
        return new ResponseEntity<>(eventService.createEvent(eventDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEvent(@PathVariable String id) {
        return new ResponseEntity<>(eventService.getEventById(id), HttpStatus.OK);
    }


 @GetMapping
    public ResponseEntity<List<EventDto>> getEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateAnEvent(@PathVariable String id, @Valid @RequestBody EventDto eventDto) {

        return new ResponseEntity<>(eventService.updateEvent(eventDto,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> removeEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(ApiResponse.builder().response("event deleted successfully").status(true).httpStatus(HttpStatus.ACCEPTED).build(), HttpStatus.OK);
    }
//
//

}
