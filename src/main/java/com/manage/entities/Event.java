package com.manage.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
public class Event {

    @Id

    private String id;
//    @ManyToMany
//    @JoinTable(
//            name = "user_event", // Join table name
//            joinColumns = @JoinColumn(name = "event_id"), // Column in the join table for the event
//            inverseJoinColumns = @JoinColumn(name = "") // Column in the join table for the user
//    )
//    private List<Login> users = new ArrayList<>();
    private String name;
    private String description;
    private String location;

private Date date;
private String url;
private String image;
private String category;
}
