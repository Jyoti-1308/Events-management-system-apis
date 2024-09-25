package com.manage.service;

import com.manage.dto.EventDto;

import java.util.List;


public interface EventService {
    EventDto createEvent(EventDto eventDto);
    List<EventDto> getAllEvents();

    EventDto updateEvent(EventDto eventDto,String id);
    void deleteEvent(String id);
    EventDto getEventById(String id);
//    EventDto getBookedEventsByUsername(String name);
}
