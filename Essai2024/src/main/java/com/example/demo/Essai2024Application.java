package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.Hello;
import com.example.demo.bean.Ihello;

@SpringBootApplication
public class Essai2024Application implements CommandLineRunner{
	
	
	//@Autowired //depricated
	Ihello hello;
	@Autowired 
	public Essai2024Application (Ihello french) {//injection par constructeur
		this.hello=french;
	}

	public static void main(String[] args) {
		SpringApplication.run(Essai2024Application.class, args);
	}
	
	public void run (String ... args) throws Exception {
		System.out.println(hello.getMessage("Spring"));
	}

}
