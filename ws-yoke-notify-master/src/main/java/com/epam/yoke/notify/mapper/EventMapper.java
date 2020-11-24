package com.epam.yoke.notify.mapper;

import com.epam.yoke.notify.model.Event;
import com.epam.yoke.notify.model.rq.AttenderEventBody;
import com.epam.yoke.notify.model.rq.EventBody;
import com.epam.yoke.notify.model.rs.EventResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

  EventResponse mapResponse(Event source);

  Event mapRequest(EventBody source);

  Event mapAttenderRequest(AttenderEventBody source);

}
