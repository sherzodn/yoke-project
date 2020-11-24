package com.epam.yoke.event.service;

import com.epam.yoke.event.entity.Event;
import com.epam.yoke.event.mapper.EventMapper;
import com.epam.yoke.event.model.EventStatus;
import com.epam.yoke.event.model.rq.EventBody;
import com.epam.yoke.event.model.rs.EventResponse;
import com.epam.yoke.event.model.rs.NotifyEventResponse;
import com.epam.yoke.event.repository.EventRepository;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EventService {

  private static final Logger logger = LoggerFactory.getLogger(EventService.class);

  private EventRepository eventRepository;
  private EventMapper eventMapper;

  @Autowired
  public EventService(EventRepository eventRepository, EventMapper eventMapper) {
    this.eventRepository = eventRepository;
    this.eventMapper = eventMapper;
  }

  public List<EventResponse> findEvents() {
    return eventMapper.mapResponses((List<Event>) eventRepository.findAll());
  }

  public EventResponse findEventById(String id) {
    logger.info("Find id: {}", id);
    Event event = eventRepository.findById(Long.valueOf(id))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Couldn't find event with id:" + id));
    return eventMapper.mapResponse(event);
  }

  public EventResponse saveEvent(EventBody event) {
    Event inputEvent = eventMapper.mapRequest(event);
    inputEvent.setStatus(EventStatus.CREATED);
    Event savedEvent = eventRepository.save(inputEvent);
    logger.info("Saved to DB: {}", savedEvent);
    EventResponse res = eventMapper.mapResponse(savedEvent, event.getDescription());
    return res;
  }

  public void deleteEvent(String id) {
    eventRepository.deleteById(Long.valueOf(id));
    logger.info("Deleted to DB: {}", id);
  }
}
