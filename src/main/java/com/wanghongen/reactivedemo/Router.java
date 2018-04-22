package main.java.com.wanghongen.reactivedemo;

import main.java.com.wanghongen.reactivedemo.handlers.HelloWorldHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class Router {

  @Autowired
  private HelloWorldHandler helloWorldHandler;
//  @Autowired
//  private UserHandler userHandler;

  @Bean
  public RouterFunction<?> routerFunction() {
    return RouterFunctions.route(RequestPredicates.GET("/hello"), helloWorldHandler::helloWorld);
  }

}
