package com.epam.yoke.event.model.rq;

import java.util.Date;

import javax.validation.constraints.NotNull;

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
@ApiModel(description = "Body for create event")
public class EventBody {

  @NotNull(message = "Date is mandatory")
  @ApiModelProperty(required = true, value = "Requested date")
  private Date date;

  @NotNull(message = "Capacity is mandatory")
  @ApiModelProperty(required = true, value = "Requested capacity")
  private Integer capacity;

  @NotNull(message = "Slot is mandatory")
  @ApiModelProperty(required = true, value = "Requested slot")
  private Integer slot;

  @NotNull(message = "LocationId is mandatory")
  @ApiModelProperty(required = true, value = "Requested locationId")
  private Long locationId;

  @ApiModelProperty(value = "Event description")
  private String description;
}
