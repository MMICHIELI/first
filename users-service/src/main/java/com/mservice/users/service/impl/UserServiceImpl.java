package com.mservice.users.service.impl;

import com.mservice.users.model.dao.IUserDao;
import com.mservice.users.model.entity.User;
import com.mservice.users.service.IUserService;
import com.mservice.users.service.dto.UserDto;

import com.mservice.users.service.mapping.UserMappingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of IUserService
 */
@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  IUserDao userDao;

  @Autowired
  UserMappingService userMappingService;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public UserDto getById(Long userId) {
    LOGGER.info("USER [SERVICE] GET User by ID: " + userId);
    UserDto userDto = null;

    Optional<User> user = userDao.findById(userId);
    if (user.isPresent())
      userDto = userMappingService.entityToDto(user.get());

    return userDto;
  }

  @Override
  public List<UserDto> list() {
    LOGGER.info("USER [SERVICE] GET All Users ");
    List<UserDto> userDtos = null;

    List<User> users = userDao.findAll();
    if (users != null)
      userDtos = userMappingService.entitiesToDto(users);

    return userDtos;
  }

  @Override
  public UserDto save(UserDto userDto) {
    LOGGER.info("USER [SERVICE] Save User");

    UserDto response = null;
    User user = userDao.save(userMappingService.dtoToEntity(userDto));
    if (user != null)
      response = userMappingService.entityToDto(user);

    return response;
  }

  @Override
  public void delete(Long userId) {
    LOGGER.info("USER [SERVICE] Delete User by Id: " + userId);
    userDao.deleteById(userId);
  }
}
