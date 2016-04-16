package com.marlon;

import java.util.concurrent.atomic.AtomicInteger;
import org.jooby.mvc.Path;
import org.jooby.mvc.GET;

@Path("/greeting")
public class Greetings {

  static AtomicInteger idgen = new AtomicInteger();

  @GET
  public Greeting salute() {
    return new Greeting(idgen.incrementAndGet(), "Hello World!");
  }
}