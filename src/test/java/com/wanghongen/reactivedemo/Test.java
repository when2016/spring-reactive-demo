package com.wanghongen.reactivedemo;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Test {


  public static void main(String[] args) throws InterruptedException {

    Flux<String> s = Flux.range(1, 5)
        .map(v -> doSomethingDangerous(v))
        .map(v -> doSecondTransform(v));
    s.subscribe(value -> System.out.println("RECEIVED " + value),
        error -> System.err.println("CAUGHT " + error)
    );

    Flux.just(10)
        .map(v -> doSomethingDangerous(v))
        .onErrorReturn("RECOVERED");

    Flux.interval(Duration.ofMillis(250))
        .map(input -> {
          if (input < 3) return "tick " + input;
          throw new RuntimeException("boom");
        })
        .elapsed()
        .retry(1)
        .subscribe(System.out::println, System.err::println);

    Thread.sleep(2100);


  }

  private static String doSecondTransform(String v) {
    System.out.println(v);
    return v;
  }

  private static String doSomethingDangerous(Integer v) {
    return Integer.toString(v);
  }

}
