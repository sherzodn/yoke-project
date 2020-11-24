package com.epam.yoke.event.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.yoke.event.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
