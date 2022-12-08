package com.springboot.spring_boot_first_App.second.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
@GetMapping("/home")
	public String Home() {
		return "This is home page";
	}
	

}
