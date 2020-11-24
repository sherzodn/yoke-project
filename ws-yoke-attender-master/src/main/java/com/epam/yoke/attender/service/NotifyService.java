package com.epam.yoke.attender.service;

import com.epam.yoke.attender.dao.NotifierDao;
import com.epam.yoke.attender.model.rq.AttenderEventBody;
import com.epam.yoke.attender.model.rs.AttenderEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotifyService {

  @Autowired
  private NotifierDao notifierDao;

  public AttenderEventResponse add(AttenderEventBody event) {
    return notifierDao.addAttender(event);
  }

  public void delete(String eventId, String email) {
    notifierDao.deleteAttender(eventId, email);
  }
}
