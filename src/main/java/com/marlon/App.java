package com.marlon;

import org.jooby.Jooby;
import org.jooby.json.Jackson;

public class App extends Jooby {


  {
    /**
     * Instancia o Jackson
     */
  	use(new Jackson());
    /**
     * Importa os arquivos estáticos
     */
  	assets("/assets/**");
  	assets("/","index.html");
    /**
     * Instancia o controller dos Todos
     */
    use(Todos.class);
  }
  /**
   * Inicializa a aplicação
   */
  public static void main(final String[] args) throws Exception {
    run(App::new, args);
  }
}
