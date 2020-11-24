package com.epam.yoke.event.model.rs;

import java.util.Date;

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
@ApiModel(description = "Event response")
public class EventResponse {

  @ApiModelProperty(required = true, value = "Event id")
  private Long id;

  @ApiModelProperty(required = true, value = "Event date")
  private Date date;

  @ApiModelProperty(required = true, value = "Event capacity")
  private Integer capacity;

  @ApiModelProperty(required = true, value = "Event slot")
  private Integer slot;

  @ApiModelProperty(required = true, value = "Event locationId")
  private Long locationId;

  @ApiModelProperty(value = "Event description")
  private String description;
}
