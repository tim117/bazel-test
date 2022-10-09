package com.bwe.readingoasis.model;

import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class ApiListResponse<T> {
  public static <T> Builder<T> builder(T obj) {
    return new AutoValue_ApiListResponse.Builder<T>();
  }

  public abstract List<T> getData();

  public abstract int getPage();

  public abstract int getSize();

  public abstract int getTotal();

  @AutoValue.Builder
  public interface Builder<T> {
    Builder<T> setData(List<T> data);

    Builder<T> setPage(int page);

    Builder<T> setSize(int size);

    Builder<T> setTotal(int total);

    ApiListResponse<T> build();
  }
}
