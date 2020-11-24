package com.epam.yoke.attender.model.entity;

import com.epam.yoke.attender.model.EventStatus;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "event")
@Data
public class Event {

  public Event() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @NonNull
  @Column(name = "transactionId")
  private Long transactionId;

  @NonNull
  @Enumerated(EnumType.ORDINAL)
  @Column(name = "status")
  private EventStatus status;

  @NonNull
  @Column(name = "date")
  private Date date;

  @NonNull
  @Column(name = "capacity")
  private Integer capacity;

  @NonNull
  @Column(name = "slot")
  private Integer slot;

  @NonNull
  @Column(name = "locationId")
  private Long locationId;
}

