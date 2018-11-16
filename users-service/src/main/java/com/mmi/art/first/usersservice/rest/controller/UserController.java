package com.mmi.art.first.usersservice.rest.controller;

import com.mmi.art.first.usersservice.service.IUserService;
import com.mmi.art.first.usersservice.service.dto.UserDto;
import com.mmi.art.first.usersservice.rest.exceptions.NoUserException;
import com.mmi.art.first.usersservice.rest.exceptions.UserNotFoundException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/users")
@Api(description = "User Micro-Service", value = "/users")
public class UserController {

  @Autowired
  IUserService userService;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


  @GetMapping
  @ApiOperation(value = "List All Users", response = Iterable.class, responseContainer = "ResponseEntity")
  public ResponseEntity<Iterable<UserDto>> list() throws NoUserException {
    LOGGER.info("USER [CONTROLLER] - GET All Users ");

    Iterable<UserDto> userDtos = userService.list();
    if (userDtos == null)
      throw new NoUserException("Il n'y a Aucun utilisateur.");
    else
      return new ResponseEntity<>(userDtos, OK);
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Get a User by id", response = UserDto.class, responseContainer = "ResponseEntity")
  public ResponseEntity<UserDto> getById(
      @PathVariable("id") @ApiParam(value = "User Id", required = true) Long userId)
      throws UserNotFoundException {
    LOGGER.info("USER [CONTROLLER] - GET User by id: " + userId);

    UserDto userDto = userService.getById(userId);
    if (userDto == null)
      throw new UserNotFoundException("L'utilisateur avec l' id: " + userId + " n'existe pas.");
    else
      return new ResponseEntity<>(userDto, OK);
  }

  @PostMapping
  @ApiOperation(value = "Create a new User", response = UserDto.class, responseContainer = "ResponseEntity")
  public ResponseEntity<UserDto> create(
      @Valid @RequestBody @ApiParam(value = "User Informations", required = true) UserDto userDto
  ) {
    LOGGER.info("USER [CONTROLLER] - CREATE a new User = {name: " + userDto.getName() + ", firstName: " + userDto.getFirstName() + " }");
    UserDto userDtoCreated = userService.save(userDto);

    if (userDtoCreated == null)
      return ResponseEntity.noContent().build();

    return new ResponseEntity<>(userDtoCreated, CREATED);
  }

  @PutMapping(value = "/{id}")
  @ApiOperation(value = "Update User", response = UserDto.class, responseContainer = "ResponseEntity")
  public ResponseEntity<UserDto> update(
      @Valid @RequestBody @ApiParam(value = "User Information", required = true) UserDto userDto,
      @PathVariable("id") @ApiParam(value = "manufacturing id", required = true) Long userId
  ) {
    LOGGER.info("USER [CONTROLLER] - Update User = {id: " + userId + ", name: " + userDto.getName() + ", firstName: " + userDto.getFirstName() + " }");
    UserDto userDtoUpdated = userService.save(userDto);

    if (userDtoUpdated == null)
      return ResponseEntity.noContent().build();

    return new ResponseEntity<>(userDtoUpdated, OK);
  }

  @DeleteMapping(value = "/{id}")
  @ApiOperation(value = "Delete a User", responseContainer = "ResponseEntity")
  public void delete(
      @PathVariable("id") @ApiParam(value = "User Id to Delete", required = true) Long userId) {
    LOGGER.info("USER [CONTROLLER] - DELETE User by id: " + userId);
    userService.delete(userId);
  }
}
