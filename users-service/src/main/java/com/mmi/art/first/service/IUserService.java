package com.mmi.art.first.service;

import com.mmi.art.first.service.dto.UserDto;

import java.util.List;

/**
 * All User Services
 */
public interface IUserService {

  /**
   * Display a specific User
   * @param userId
   */
  UserDto getById(Long userId);

  /**
   * List All
   */
  List<UserDto> list();

  /**
   * Save
   * @param user
   * @return UserDto
   */
  UserDto save(UserDto user);

  /**
   * Delete
   * @param userId
   */
  void delete(Long userId);
}
