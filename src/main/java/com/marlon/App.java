package com.marlon;

import org.jooby.Jooby;
import org.jooby.json.Jackson;

/**
 * @author jooby generator
 */
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
