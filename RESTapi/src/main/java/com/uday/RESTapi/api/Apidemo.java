package com.uday.RESTapi.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uday")
public class Apidemo {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
}
