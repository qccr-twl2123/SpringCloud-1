package com.example.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${greeting}")
	private String greeting;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello, " + greeting;
	}
}
