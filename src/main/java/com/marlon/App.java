package com.marlon;

import org.jooby.Jooby;
import org.jooby.json.Jackson;

/**
 * @author jooby generator
 */
public class App extends Jooby {


  {
	use(new Jackson());
	get("/", () -> "Hello World!");
    use(Greetings.class);
  }

  public static void main(final String[] args) throws Exception {
    run(App::new, args);
  }

}
