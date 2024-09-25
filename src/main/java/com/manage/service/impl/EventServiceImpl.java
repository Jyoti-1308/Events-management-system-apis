package com.manage.service.impl;


import com.manage.dto.EventDto;


import com.manage.entities.Event;
import com.manage.exception.ResourceNotFoundException;
import com.manage.repositories.EventRepo;
import com.manage.service.EventService;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        eventDto.setId(UUID.randomUUID().toString());
    return modelMapper.map(eventRepo.save(modelMapper.map(eventDto,Event.class)),EventDto.class);

    }
    @Override
    public EventDto updateEvent(EventDto eventDto,String id) {

        Event existingEvent = eventRepo.findById(id).get();
        modelMapper.map(eventDto, existingEvent);

    // Save the updated event
        Event updatedEvent = eventRepo.save(existingEvent);

    // Return the updated event as a DTO
        return modelMapper.map(updatedEvent, EventDto.class);

    }


    @Override
    public void deleteEvent(String id) {
        System.out.println(id);
        eventRepo.delete(eventRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + id)));


    }
//
//    @Override
//    public CustomerDto updateCustomer(String existingCustomerId, CustomerDto customerDto) {
//        Customer customer = customerRepo.findById(existingCustomerId).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + existingCustomerId));
//        customer.setName(customerDto.getName());
//        customer.setEmail(customerDto.getEmail());
//        customer.setAddress(customerDto.getAddress());
//        customer.setPhone(customerDto.getPhone());
//        customer.setNotes(customerDto.getNotes());
//        return modelMapper.map(customerRepo.save(customer), CustomerDto.class);
//    }
//
    @Override
    public List<EventDto> getAllEvents() {

       List<Event> events=eventRepo.findAll();

//        return Helper.getPageableResponse(customerRepo.findAll(PageRequest.of(pageNumber, pageSize, sortDirection.equalsIgnoreCase("desc") ?
//                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending())), CustomerDto.class);

        return events.stream()
                .map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());
    }
//
    @Override
    public EventDto getEventById(String eventId) {
        Event event=eventRepo.findById(eventId).get();
        return modelMapper.map(event,EventDto.class);

    }
}
