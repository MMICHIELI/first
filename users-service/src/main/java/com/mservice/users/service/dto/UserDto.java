package com.mservice.users.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * User Bean
 */
@Data
public class UserDto implements Serializable {

  private Long id;

  private String name;
  private String firstName;
}
