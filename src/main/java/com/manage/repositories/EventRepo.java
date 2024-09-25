package com.manage.repositories;


import com.manage.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, String> {

}
