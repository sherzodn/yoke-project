package com.epam.yoke.event.entity;

import com.epam.yoke.event.model.EventStatus;
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
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "event")
@Data
@NoArgsConstructor
public class Event {

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
