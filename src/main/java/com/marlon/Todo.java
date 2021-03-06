/**
 * Modelo para Todo
 * @author Marlon Lúcio
 */

package com.marlon;

public class Todo {

  public int id;

  public String name;

  public Todo(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
