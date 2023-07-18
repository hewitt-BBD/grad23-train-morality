package com.train.resource_server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebController
 */
@RestController("public")
public class WebController {

  @RequestMapping("greeting")
  public String hello() {
    return "Greetings, stranger!";
  }
}

