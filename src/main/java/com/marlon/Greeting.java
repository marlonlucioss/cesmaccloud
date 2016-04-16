package com.marlon;

public class Greeting {

  public int id;

  public String name;

  public Greeting(final int id, final String name) {
    this.id = id;
    this.name = name;
  }

  public String toString() {
    return name;
  }
}