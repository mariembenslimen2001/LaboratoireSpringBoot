package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component("french")
public class Bonjour implements Ihello {

	
	public String getMessage(String msg) {
		// TODO Auto-generated method stub
		return "Bonjour"+msg;
	}

}
