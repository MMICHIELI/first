package com.mmi.art.first.usersservice.service.mapping;

import com.mmi.art.first.usersservice.service.dto.UserDto;
import com.mmi.art.first.usersservice.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User to Dto & Dto to User Mapping Service
 */
@Service
public class UserMappingService {

  /**
   * entityToDto
   * @param user
   * @return new UserDto()
   */
  public UserDto entityToDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setFirstName(user.getFirstName());
    return userDto;
  }

  /**
   * entitiesToDto
   * @param users
   * @return List<UserDto>
   */
  public List<UserDto> entitiesToDto(List<User> users) {
    return users
        .stream()
        .map(this::entityToDto)
        .collect(Collectors.toList());
  }

  /**
   * dtoToEntity
   * @param userDto
   * @return User
   */
  public User dtoToEntity(UserDto userDto) {
    User user = new User();
    user.setId(userDto.getId());
    user.setFirstName(userDto.getFirstName());
    user.setName(userDto.getName());
    return user;
  }
}
