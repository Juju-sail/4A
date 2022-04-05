package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "toi") String name) {
		return String.format("Hello %s!", name);
	}
	@GetMapping("/hello2/{name}")
	public String hello2(
			@PathVariable(value = "name") String name, 
			@RequestParam(value = "love", defaultValue = "<3") String love)
	{
		return String.format("Hello %s %s", name, love, " !");
	}
	
	

}