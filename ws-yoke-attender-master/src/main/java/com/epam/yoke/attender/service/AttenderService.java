package com.epam.yoke.attender.service;

import com.epam.yoke.attender.mapper.AttenderMapper;
import com.epam.yoke.attender.model.entity.Event;
import com.epam.yoke.attender.model.entity.User;
import com.epam.yoke.attender.model.rq.AttenderBody;
import com.epam.yoke.attender.model.rs.AttenderResponse;
import com.epam.yoke.attender.repository.EventRepository;
import com.epam.yoke.attender.repository.UserRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class AttenderService {
  private static final Logger logger = LoggerFactory.getLogger(AttenderService.class);

  @Autowired
  private EventRepository eventRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AttenderMapper attenderMapper;

  public List<Event> findEvents() {
    return (List<Event>) eventRepository.findAll();
  }

  public User findUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Couldn't find event with id:" + id));
  }

  public Event saveEvent(Event event) {
    return eventRepository.save(event);
  }

  public AttenderResponse saveAttender(AttenderBody attender) {
    User user = userRepository.save(attenderMapper.mapRequest(attender));
    logger.info("Saved to DB: {}", user);
    return attenderMapper.mapResponses(user);
  }
}
