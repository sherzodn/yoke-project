package com.epam.yoke.attender.model.rq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(description = "Body for create attender event")
public class AttenderEventBody {

  @NotNull(message = "EventId is mandatory")
  @ApiModelProperty(required = true, value = "Requested eventId")
  private String eventId;

  @NotNull(message = "Emails is mandatory")
  @ApiModelProperty(required = true, value = "Requested emails")
  private List<String> emails;
}
