package com.marlon;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.ArrayList;
import org.jooby.mvc.Path;
import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.DELETE;
import org.jooby.mvc.PUT;

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
  public List postTodo(String name) {
	todoList.add(new Todo(idgen.incrementAndGet(), name));
	return todoList;
  }
  @DELETE
  public List deleteTodo(int id) {
	todoList.remove(position);
	return todoList;
  }
  @PUT
  public List updateTodo(Todo todo, int position) {
	todoList.remove(position);
	return todoList;
  }
}