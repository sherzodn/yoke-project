package com.epam.yoke.notify.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Report {

  private String eventId;
  private String title;
  private String description;
}
