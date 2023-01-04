package com.pp.web;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CrudSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Estudiante e1 = new Estudiante("Carlos","Ochoa","hola@mail.com");
		repositorio.save(e1);
		

		Estudiante e2 = new Estudiante("Miguel","Ramirez","hola2@mail.com");
		repositorio.save(e2);
		*/
	}

}
