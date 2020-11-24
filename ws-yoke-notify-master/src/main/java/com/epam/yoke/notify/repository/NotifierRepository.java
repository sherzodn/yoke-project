package com.epam.yoke.notify.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.epam.yoke.notify.model.Event;

public interface NotifierRepository extends MongoRepository<Event, String> {

  Event findEventByEventIdIs(String eventId);
}
