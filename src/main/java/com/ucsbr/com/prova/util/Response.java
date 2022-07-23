package com.ucsbr.com.prova.util;

import com.ucsbr.com.prova.entity.enumerator.ResponseStatus;
import lombok.Data;

@Data
public class Response<T>{
  private T data;
  private ResponseStatus status;
  private Integer errorCode;
  private String errorMessage;
}
