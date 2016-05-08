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
import java.util.Map;

@Path("")
public class Todos {

  static AtomicInteger idgen = new AtomicInteger();
  public List todoList = new ArrayList<Todo>();
  public Todo todo;

  @GET
  @Path("/todos")
  public List getTodoList() {
    todoList.add(new Todo(idgen.incrementAndGet(),"Marlon1"));
    todoList.add(new Todo(idgen.incrementAndGet(),"Marlon2"));
    todoList.add(new Todo(idgen.incrementAndGet(),"Marlon3"));
    todoList.add(new Todo(idgen.incrementAndGet(),"Marlon4"));
    todoList.add(new Todo(idgen.incrementAndGet(),"Marlon5"));
    return todoList;
  }

  @POST
  @Path("/todos/add")
  public List addTodo(@Body Map newTodo) {
    todo = new Todo(idgen.incrementAndGet(),(String)newTodo.get("name"));
    todoList.add(todo);
    return todoList;
  }
  @DELETE
  @Path("/todos/delete")
  public List deleteTodo(@Body Todo todoToUpdate) {
    todoList.remove(todoToUpdate);
    return todoList;
  }
  @PUT
  @Path("/todos/update")
  public List updateTodo(@Body Todo todoToUpdate) {
    todoList.remove(todoToUpdate);
    return todoList;
  }
}
