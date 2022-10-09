package com.bwe.readingoasis.model;

import com.google.auto.value.AutoValue;

/**
 * A representation of a resource response from the API.
 *
 * @param <T> The model to use for the data field
 */
@AutoValue
public abstract class ApiResponse<T> {
  public static <T> Builder<T> builder(T obj) {
    return new AutoValue_ApiResponse.Builder<>();
  }

  public abstract T getData();

  @AutoValue.Builder
  public interface Builder<T> {
    Builder<T> setData(T data);

    ApiResponse<T> build();
  }
}
