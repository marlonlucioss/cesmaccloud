# Cesmaccloud

Este repositório se trata de um projeto de avaliação da matéria Tópicos Especiais em Engenharia de Software, do curso de pós graduação em Engenharia de Software do Cesmac.

O projeto consiste em desenvolver um REST Web Server em fase inicial, contendo os métodos básicos GET, POST, PUT e DELETE (Cada membro da equipe deverá implementar um deles). Fazendo uso do Jooby foi criado o backend da aplicação, o JUnit foi utilizado para realização de testes de unidade e as requisições ficaram por conta do cUrl.

As dependências são:

1. Java 8 [aqui](http://www.oracle.com/technetwork/pt/java/javase/downloads/jre8-downloads-2133155.html)
2. Maven 3.x [aqui](http://maven.apache.org/download.cgi)
3. Jooby [aqui](http://jooby.org/)

##Rodando o projeto

Para rodar o projeto:

```
mvn jooby:run
```

Para que fosse possível trabalhar com trocas de mensagens no formato json, foi necessário a adição de uma dependência no pom.xml:

A dependência consiste no Jackson:

```
<dependency>
  <groupId>org.jooby</groupId>
  <artifactId>jooby-jackson</artifactId>
</dependency>
```

##Estrutura Base

O web service conta com 3 arquivos:

App.java
```java
package com.marlon;

import org.jooby.Jooby;
import org.jooby.json.Jackson;

public class App extends Jooby {


  {
  	use(new Jackson());
  	assets("/assets/**");
  	assets("/","index.html");
    use(Todos.class);
  }

  public static void main(final String[] args) throws Exception {
    run(App::new, args);
  }
}
```

onde:

Importamos o Jackson
```java
import org.jooby.json.Jackson;
```

o inicializamos.
```java
use(new Jackson());
```

Inicializamos o controller que irá tratar os métodos referentes aos TODOS.
```java
use(Todos.class);
```

e então, inicializamos a aplicação
```java
public static void main(final String[] args) throws Exception {
  run(App::new, args);
}
```

Todo.java

Que é o modelo de todo.

```java
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
```

e Todos.java

que consiste no controller que irá manipular as requisições o os Todos.

```java
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
```

onde:

São feitos os imports necessários
```java
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
```

Alocamos memória para os elementos que serão utilizados pelos métodos subsequentes
```java
static AtomicInteger idgen = new AtomicInteger();
public List todoList = new ArrayList<Todo>();
public Todo todo;
```

O método 'GET' é implementado, onde podemos acessá-lo via um requisição get pelo navegador para 'localhost:8080/todos'
```java
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
```

onde:


Adicionamos vários Todos em memória
```java
todoList.add(new Todo(idgen.incrementAndGet(),"Marlon1"));
todoList.add(new Todo(idgen.incrementAndGet(),"Marlon2"));
todoList.add(new Todo(idgen.incrementAndGet(),"Marlon3"));
todoList.add(new Todo(idgen.incrementAndGet(),"Marlon4"));
todoList.add(new Todo(idgen.incrementAndGet(),"Marlon5"));
```

retornamos uma lista de Todos em formato json
```java
return todoList;
```

Foi implementado também um método que suporta uma requisição HTTP do tipo POST para 'localhost:8080/todos/add'
```java
@POST
@Path("/todos/add")
public List addTodo(@Body Map newTodo) {
  todo = new Todo(idgen.incrementAndGet(),(String)newTodo.get("name"));
  todoList.add(todo);
  return todoList;
}
```

onde:

O formato do json deve seguir o seguinte padrão:
```json
{
  "name":"Nome do Todo"
}
```

com isso, recebemos um novo Todo em formato json através do corpo da requisição
```java
public List addTodo(@Body Map newTodo)
```

criamos um novo Todo contendo o nome vindo na requisição
```java
todo = new Todo(idgen.incrementAndGet(),(String)newTodo.get("name"));
```

adicionamos o novo Todo na lista de Todos e retornamos a lista de Todos atualizada
```java
todoList.add(todo);
return todoList;
```
