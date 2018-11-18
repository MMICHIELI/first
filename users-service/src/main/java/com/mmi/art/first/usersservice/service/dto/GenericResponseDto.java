package com.mmi.art.first.usersservice.service.dto;

import lombok.Data;

/**
 * Common Object used to model the response
 * @param <T>
 */
@Data
public class GenericResponseDto<T> {
  private String code;
  private String label;
  private T responseData;
}
