package com.alisenturk.reactive.ReactiveDemo.webclient;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import reactor.core.publisher.Flux;

public class WebClientTest {
	private WebClient client = WebClient.create("http://localhost:8080");

	  private ResponseSpec result = client.get()
	      .uri("/api/test/list")
	      .accept(MediaType.APPLICATION_STREAM_JSON)
	      .retrieve();

	  public void getResult() {
		  Flux<String> flux = result
          .bodyToFlux(String.class).distinct().delayElements(Duration.ofSeconds(1));
		  flux.last().map(s-> String.valueOf(s)).subscribe(msg -> {
			 System.out.println("aa..:" + msg); 
		  });
		  /*
          .map(s -> String.valueOf(s))
          .subscribe(msg -> {
        	  
              System.out.println(msg);
          }); */
	  }
}
