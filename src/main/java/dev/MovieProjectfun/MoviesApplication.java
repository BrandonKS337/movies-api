package dev.MovieProjectfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// NOTE: These imports and the RestController are for the Hello World endpoint example below
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //NOTE: This is for the example endpoint for Hello World
public class MoviesApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MoviesApplication.class, args);
	}

	//Using this as an example of setting up an endpoint example in Java.
	@GetMapping("/") //this is a way of saying that the apiRoot below is a GET endpoint. Defined by declaring the endpoint
	public String apiRoot() {
		return "Hello, World!"; 
	}




}
