package com.epam.yoke.event.model.rs;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NotifyEvent {

  public String eventId;
  public List<String> emails;
  public String description;
}
