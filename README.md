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
