package com.mservice.users.rest.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class NoUserException extends Throwable {

  public NoUserException(String s) {
    super(s);
  }
}
