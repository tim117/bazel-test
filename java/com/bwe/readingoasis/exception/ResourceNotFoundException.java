package com.bwe.readingoasis.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }

  public static ResourceNotFoundException newResourceNotFoundException(String message) {
    return new ResourceNotFoundException(message);
  }
}
