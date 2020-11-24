package com.epam.yoke.notify.controller;

import com.epam.yoke.notify.model.Event;
import com.epam.yoke.notify.model.rq.AttenderEventBody;
import com.epam.yoke.notify.model.rq.EventBody;
import com.epam.yoke.notify.model.rs.EventResponse;
import com.epam.yoke.notify.service.NotifyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/event")
@RestController
public class NotifyController {

  @Autowired
  private NotifyService notifyService;

  @GetMapping("/")
  public @ResponseBody
  List<Event> findAll() {
    return notifyService.findEvents();
  }

  @GetMapping("/{id}")
  public @ResponseBody
  Event getEventById(@PathVariable String id) {
    return notifyService.findEventById(id);
  }

  @PostMapping(value = "/")
  public EventResponse createEvent(@RequestBody EventBody event) {
    return notifyService.saveEvent(event);
  }

  @DeleteMapping(value = "/{eventId}")
  public void deleteEvent(@PathVariable String eventId) {
    notifyService.deleteEvent(eventId);
  }

  @DeleteMapping(value = "/all/")
  public void deleteAllEvents() {
    notifyService.deleteAll();
  }

  @PostMapping(value = "/attender/")
  public EventResponse createAttenderEvent(@RequestBody AttenderEventBody event) {
    return notifyService.saveEvent(event);
  }

  @DeleteMapping(value = "/{eventId}/attender/{email}")
  public void deleteAttenderFromEvent(@PathVariable String eventId, @PathVariable String email) {
    notifyService.deleteAttender(eventId, email);
  }
}
