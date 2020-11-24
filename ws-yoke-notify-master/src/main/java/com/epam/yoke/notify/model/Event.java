package com.epam.yoke.notify.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Event {

  @Id
  public String id;
  public String eventId;
  public List<String> emails;
  public String description;
}
