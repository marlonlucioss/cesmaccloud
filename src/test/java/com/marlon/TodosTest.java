package com.marlon;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;


public class TodosTest {
  @Test
  public void evaluateGetTodos() {
    Todos todos = new Todos();
    List todosList = todos.getTodoList();
    int todoCount = todosList.size();
    assertEquals(5,todoCount);
  }
}
