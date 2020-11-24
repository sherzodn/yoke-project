package com.epam.yoke.attender.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "person")
@Data
public class User {

  public User() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @NonNull
  @Size(max = 255)
  @Column(name = "email", unique = true)
  private String email;
}
