package com.alisenturk.reactive.ReactiveDemo.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alisenturk.reactive.ReactiveDemo.entity.Movie;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ReactiveTestController {


	@Autowired	
    MovieService movieService;
	
	@ResponseBody
	@GetMapping(value = "/test/list", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Collection<Movie>> getTestList(){
		System.out.println("aaa:"+new Date());
		//return Flux.interval(Duration.ofSeconds(1)).map(val-> {return movies;});
		return movieService.getAllMovies();
		//return Flux.interval(Duration.ofSeconds(1)).map(val-> String.valueOf(Math.random()) );
		
	}
	
	@ResponseBody
	@GetMapping("/test/add")
	public String addDataTestList(){
		int rndm = (int)(Math.random()*100);
		movieService.addMovie(new Movie("Test-"+rndm, rndm));
		return "OK->"+new Date();
	}
	
}
