package com.mmi.art.first.usersservice.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ms_user")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "idgen", sequenceName = "msUserSeq")
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
  @Column(name = "user_id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "first_name")
  private String firstName;
}
