package com.bwe.readingoasis.model;

public enum ApiErrorCode {
  NOT_FOUND(0),
  BAD_REQUEST(1),
  DATABASE_ERROR(2);

  private final int code;

  ApiErrorCode(int code) {
    this.code = code;
  }

  public int code() {
    return code;
  }
}
