package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component("english")
public class Hello implements Ihello{
	
	public String getMessage(String msg) {
		return "Hello"+msg;
	}

}
