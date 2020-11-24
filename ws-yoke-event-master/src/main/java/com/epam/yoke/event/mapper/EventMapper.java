package com.epam.yoke.event.mapper;

import com.epam.yoke.event.model.rq.NotifyEventBody;
import com.epam.yoke.event.model.stream.StreamEvent;
import java.util.List;
import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.epam.yoke.event.entity.Event;
import com.epam.yoke.event.model.rq.EventBody;
import com.epam.yoke.event.model.rs.EventResponse;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {

  EventResponse mapResponse(Event source);

  EventResponse mapResponse(Event source, @Context String body);

  @AfterMapping
  default void fillDescription(@MappingTarget EventResponse target, @Context String desc ){
    if (target != null){
      target.setDescription(desc);
    }
  }

  List<EventResponse> mapResponses(List<Event> source);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "transactionId", ignore = true)
  @Mapping(target = "status", ignore = true)
  Event mapRequest(EventBody source);

  @Mapping(target = "eventId", source = "id")
  StreamEvent mapEntityEvent(Event source);

  @Mapping(target = "eventId", source = "id")
  NotifyEventBody mapEntityEvent(EventResponse source);
}
