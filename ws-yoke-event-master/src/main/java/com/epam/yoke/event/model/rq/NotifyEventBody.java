package com.epam.yoke.event.model.rq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(description = "Body for create notify event")
public class NotifyEventBody {

  @ApiModelProperty(required = true, value = "Requested eventId")
  private String eventId;

  @ApiModelProperty(value = "Event description")
  private String description;
}
