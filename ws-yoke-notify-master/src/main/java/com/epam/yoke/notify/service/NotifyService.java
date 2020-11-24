package com.epam.yoke.notify.service;

import com.epam.yoke.notify.mapper.EventMapper;
import com.epam.yoke.notify.model.Event;
import com.epam.yoke.notify.model.rq.AttenderEventBody;
import com.epam.yoke.notify.model.rq.EventBody;
import com.epam.yoke.notify.model.rs.EventResponse;
import com.epam.yoke.notify.repository.NotifierRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotifyService {

  private static final Logger logger = LoggerFactory.getLogger(NotifyService.class);

  @Autowired
  private NotifierRepository repository;
  @Autowired
  private EventMapper eventMapper;

  public List<Event> findEvents() {
    return repository.findAll();
  }

  public Event findEventById(String eventId) {
    return repository.findEventByEventIdIs(eventId);
  }

  public EventResponse saveEvent(EventBody event) {
    Event eventDto = eventMapper.mapRequest(event);
    Event exitedEvent = repository.findEventByEventIdIs(event.getEventId());
    if (exitedEvent != null) {
      exitedEvent.setDescription(eventDto.getDescription());
      repository.save(exitedEvent);
    } else {
      repository.save(eventDto);
    }
    logger.info("Saved to MongoDB: {}", eventDto);
    return eventMapper.mapResponse(eventDto);
  }

  public EventResponse saveEvent(AttenderEventBody event) {
    Event eventDto = eventMapper.mapAttenderRequest(event);
    Event exitedEvent = repository.findEventByEventIdIs(event.getEventId());
    // kill me for this
    if (exitedEvent == null) {
      repository.save(eventDto);
    } else {
      List<String> emails = exitedEvent.getEmails();
      if (emails != null) {
        emails.addAll(eventDto.getEmails());
      } else {
        emails = eventDto.getEmails();
      }
      exitedEvent.setEmails(emails);
      repository.save(exitedEvent);
    }

    logger.info("Saved to MongoDB: {}", eventDto);
    return eventMapper.mapResponse(eventDto);
  }

  public void deleteAttender(String eventId, String email) {
    Event event = repository.findEventByEventIdIs(eventId);
    if (event != null) {
      List<String> emails = event.getEmails();
      if (emails != null) {
        emails.removeIf(f -> f.equalsIgnoreCase(email));
      }
      event.setEmails(emails);
      repository.save(event);
      logger.info("Deleted from MongoDB: {}", event);
    }
  }

  public void deleteEvent(String eventId) {
    Event eventDto = repository.findEventByEventIdIs(eventId);
    if (eventDto != null) {
      repository.delete(eventDto);
      logger.info("Deleted from MongoDB: {}", eventDto);
    }
  }

  public void deleteAll() {
    List<Event> eventDtos = repository.findAll();
    if (eventDtos != null) {
      repository.deleteAll(eventDtos);
      logger.info("Deleted all from MongoDB");
    }
  }
}
