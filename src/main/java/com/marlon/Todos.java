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
  /**
   * Aloca memória dos elementos a serem usados
   */
  static AtomicInteger idgen = new AtomicInteger();
  public List todoList = new ArrayList<Todo>();
  public Todo todo;

  /**
   * Método GET que retorna a lista de Todos
   */
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
  /**
   * Método POST que adiciona um novo todo e retorna a lista de Todos atualizada
   */
  @POST
  @Path("/todos/add")
  public List addTodo(@Body Map newTodo) {
    todo = new Todo(idgen.incrementAndGet(),(String)newTodo.get("name"));
    todoList.add(todo);
    return todoList;
  }
  /**
   * Método DELETE que deveria deletar um Todo e retornar a lista de Todos atualizada
   */
  @DELETE
  @Path("/todos/delete")
  public List deleteTodo(@Body Todo todoToUpdate) {
    todoList.remove(todoToUpdate);
    return todoList;
  }
  /**
   * Método PUT que deveria atualizar um Todo e retornar a lista de Todos atualizada
   */
  @PUT
  @Path("/todos/update")
  public List updateTodo(@Body Todo todoToUpdate) {
    todoList.remove(todoToUpdate);
    return todoList;
  }
}
