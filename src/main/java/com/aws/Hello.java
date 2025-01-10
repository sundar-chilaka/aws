package com.aws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api")
@RestController
public class Hello {
	@GetMapping("/hello")
	public String message() {
		return"Hello this is cool...";
	}
}
