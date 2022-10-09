package com.bwe.hello.model;

import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue()
public abstract class HelloMessage {
  public static Builder builder() {
    return new AutoValue_HelloMessage.Builder();
  }

  public abstract List<String> getMessages();

  public abstract Builder toBuilder();

  @AutoValue.Builder()
  public interface Builder {
    Builder setMessages(List<String> messages);

    HelloMessage build();
  }
}
