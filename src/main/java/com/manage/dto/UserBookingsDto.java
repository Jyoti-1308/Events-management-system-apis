package com.manage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manage.entities.Event;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBookingsDto {

    private Integer id;

    private int no_of_tickets;

    private EventDto eventdto;
    private String eventId;
    private String userId;
    private double ticketCost;
    private boolean status;
}
