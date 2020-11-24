package com.epam.yoke.notify.mapper;

import com.epam.yoke.notify.model.Event;
import com.epam.yoke.notify.model.Report;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportMapper {

  @Mapping(target = "eventId", source = "eventId")
  Report mapEvent(Event source);

  List<Report> mapEvents(List<Event> events);
}
