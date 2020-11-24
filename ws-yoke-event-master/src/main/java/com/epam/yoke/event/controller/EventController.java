package com.epam.yoke.event.controller;

import com.epam.yoke.event.model.rq.EventBody;
import com.epam.yoke.event.model.rs.EventResponse;
import com.epam.yoke.event.model.rs.NotifyEvent;
import com.epam.yoke.event.service.EventService;
import com.epam.yoke.event.service.NotifyService;
import io.swagger.annotations.ApiOperation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class EventController {

  private EventService eventService;
  private NotifyService notifyService;

  @Autowired
  public EventController(EventService eventService, NotifyService notifyService) {
    this.eventService = eventService;
    this.notifyService = notifyService;
  }

  @GetMapping("/")
  @ApiOperation(value = "Finds all events", response = Object.class)
  public @ResponseBody
  List<EventResponse> findAll() {
    return eventService.findEvents();
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Find event by id", response = EventResponse.class)
  public @ResponseBody
  EventResponse getEventById(@PathVariable String id) {
    return eventService.findEventById(id);
  }

  @PostMapping(value = "/")
  @ApiOperation(value = "Save event", response = EventResponse.class)
  public EventResponse create(@RequestBody EventBody event) {
    EventResponse response = eventService.saveEvent(event);
    notifyService.createEvent(response.getId(), response.getDescription());
    return response;
  }

  @DeleteMapping(value = "/{id}")
  @ApiOperation(value = "Delete event")
  public void delete(@PathVariable String id) {
    eventService.deleteEvent(id);
    notifyService.deleteEvent(id);
  }

  @GetMapping("/notify/all")
  @ApiOperation(value = "Notifies all events", response = Object.class)
  public @ResponseBody
  List<NotifyEvent> getNotifyEvents() {
    return notifyService.getEvents();
  }
}
