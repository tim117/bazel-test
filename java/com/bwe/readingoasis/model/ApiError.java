package com.bwe.readingoasis.model;

import com.google.auto.value.AutoValue;
import java.time.Instant;

@AutoValue
public abstract class ApiError {
  public static Builder builder() {
    return new AutoValue_ApiError.Builder();
  }

  public abstract ApiErrorCode getCode();

  public abstract String getMessage();

  public abstract int getStatus();

  public abstract Instant getTime();

  @AutoValue.Builder
  public interface Builder {
    Builder setCode(ApiErrorCode code);

    Builder setMessage(String message);

    Builder setTime(Instant time);

    Builder setStatus(int status);

    ApiError build();
  }
}
