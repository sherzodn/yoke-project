package com.epam.yoke.attender.controller;

import com.epam.yoke.attender.model.entity.User;
import com.epam.yoke.attender.model.rq.AttenderBody;
import com.epam.yoke.attender.model.rq.AttenderEventBody;
import com.epam.yoke.attender.model.rs.AttenderEventResponse;
import com.epam.yoke.attender.model.rs.AttenderResponse;
import com.epam.yoke.attender.service.AttenderService;
import com.epam.yoke.attender.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/attender", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AttenderController {

  @Autowired
  private AttenderService attenderService;
  @Autowired
  private NotifyService notifyService;

  @PostMapping(value = "/event")
  public AttenderEventResponse create(@RequestBody AttenderEventBody event) {
    return notifyService.add(event);
  }

  @DeleteMapping(value = "/event/{eventId}/{userId}")
  public void delete(@PathVariable String eventId, @PathVariable String userId) {
    User user = attenderService.findUserById(Long.valueOf(userId));
    notifyService.delete(eventId, user.getEmail());
  }

  @PostMapping(value = "/")
  public AttenderResponse add(@RequestBody AttenderBody event) {
    return attenderService.saveAttender(event);
  }
}
