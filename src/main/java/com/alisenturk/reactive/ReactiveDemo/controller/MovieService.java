package com.alisenturk.reactive.ReactiveDemo.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.alisenturk.reactive.ReactiveDemo.entity.Movie;

import reactor.core.publisher.Flux;

@Service
public class MovieService {

	private final Collection<Movie> movies =  new ArrayList<>();
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	public Flux<Collection<Movie>> getAllMovies(){
		//return Flux.just(movies);
		return Flux.fromStream(Stream.generate(() -> movies))
                
                .delayElements(Duration.ofSeconds(5));
	}
}
