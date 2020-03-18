package com.alisenturk.reactive.ReactiveDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alisenturk.reactive.ReactiveDemo.webclient.WebClientTest;

@SpringBootApplication
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
		WebClientTest gwc = new WebClientTest();
	    gwc.getResult();
	}

}
