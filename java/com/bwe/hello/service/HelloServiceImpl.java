package com.bwe.hello.service;

import com.bwe.hello.model.HelloMessage;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public final class HelloServiceImpl implements com.bwe.hello.service.HelloService {

  @Override
  public HelloMessage sayHello(String name) {
    if (name == null || name.isEmpty()) {
      name = "there";
    }
    return HelloMessage.builder()
        .setMessages(Collections.singletonList("Hello " + name))
        .build();
  }

  @Override
  public HelloMessage sayHello(String[] names) {
    if (names == null || names.length == 0) {
      names = new String[]{"there"};
    }
    return HelloMessage.builder()
        .setMessages(
            Arrays.stream(names.clone()).map(name -> "Hello " + name).collect(Collectors.toList()))
        .build();
  }
}
