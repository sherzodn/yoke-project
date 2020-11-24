package com.epam.yoke.attender.repository;

import org.springframework.data.repository.CrudRepository;

import com.epam.yoke.attender.model.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
