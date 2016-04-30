package com.marlon;

import org.jooby.Request;

import org.jooby.mvc.Consumes;
import org.jooby.mvc.Produces;
import org.jooby.mvc.Body;
import org.jooby.mvc.Path;
import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.DELETE;
import org.jooby.mvc.PUT;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;
//import org.junit.Test;

@Path("/todo")
public class Todos {

  static AtomicInteger idgen = new AtomicInteger();
  public List todoList = new ArrayList<Todo>();
  private int position;

  @GET
  public List getTodoList() {
    return todoList;
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public List addTodo(@Body Todo newTodo) {
    todoList.add(newTodo);
    return todoList;
  }
  @DELETE
  public List deleteTodo(@Body Todo todoToUpdate) {
    todoList.remove(todoToUpdate);
    return todoList;
  }
  @PUT
  public List updateTodo(@Body Todo todoToUpdate) {
    todoList.remove(todoToUpdate);
    return todoList;
  }
}