package com.bwe.hello.controller;

import com.bwe.hello.model.HelloMessage;
import com.bwe.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
  private final HelloService helloService;

  @Autowired
  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping(name = "/")
  public HelloMessage hello(@RequestParam(name = "name", required = false) String[] names) {
    if (names != null && names.length == 1) {
      return helloService.sayHello(names[0]);
    }

    return helloService.sayHello(names);
  }
}
