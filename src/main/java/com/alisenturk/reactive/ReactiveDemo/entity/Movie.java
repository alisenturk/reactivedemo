package com.alisenturk.reactive.ReactiveDemo.entity;

public class Movie {
	private String name;
    private Integer score;
    
    public Movie(){
    	
    }
    
	public Movie(String name, Integer score) {
		super();
		this.name = name;
		this.score = score;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

    
}
