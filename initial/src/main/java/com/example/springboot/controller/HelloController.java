package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "ciao Pit!";
	}
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("Hello Spring!!");
	}
	@GetMapping("/good-morning")
	public ResponseEntity<String> goodMorning() {
		if(new Date().getHours() < 10){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("Good AfterNoon!");
	}
	@GetMapping(value = "/goods-moring")
	public ResponseEntity<String>indexx(){
		return ResponseEntity.ok("Good");
	}

}
