package com.epam.yoke.notify.service;

import com.epam.yoke.notify.mapper.ReportMapper;
import com.epam.yoke.notify.model.Event;
import com.epam.yoke.notify.model.Report;
import com.epam.yoke.notify.repository.NotifierRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportService {

  private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

  @Autowired
  private NotifierRepository repository;
  @Autowired
  private ReportMapper reportMapper;

  public Report getReport(String eventId) {
    Event event = repository.findEventByEventIdIs(eventId);
    return reportMapper.mapEvent(event);
  }

  public List<Report> getReports() {
    List<Event> events = repository.findAll();
    return reportMapper.mapEvents(events);
  }
}
