package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
	public class HelloController{
		@GetMapping (value = "/Hello")
		public String sayHello () {
				return "Hello";
}
}
