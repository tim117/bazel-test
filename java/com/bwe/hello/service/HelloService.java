package com.bwe.hello.service;

import com.bwe.hello.model.HelloMessage;

public interface HelloService {
  HelloMessage sayHello(String name);

  HelloMessage sayHello(String[] names);
}
