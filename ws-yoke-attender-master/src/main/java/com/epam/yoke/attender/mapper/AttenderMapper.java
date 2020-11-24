package com.epam.yoke.attender.mapper;

import com.epam.yoke.attender.model.entity.User;
import com.epam.yoke.attender.model.rq.AttenderBody;
import com.epam.yoke.attender.model.rs.AttenderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttenderMapper {

  User mapRequest(AttenderBody source);

  AttenderResponse mapResponses(User source);

}
