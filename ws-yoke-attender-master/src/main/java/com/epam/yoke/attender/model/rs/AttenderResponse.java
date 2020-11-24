package com.epam.yoke.attender.model.rs;

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
@ApiModel(description = "Attender response")
public class AttenderResponse {

  @ApiModelProperty("Requested name")
  private String name;

  @ApiModelProperty("Requested email")
  private String email;

  @ApiModelProperty("Requested id")
  private String id;
}
