package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//esto es una anotación: Java annotations are pieces of metadata that provide information about the code they are used with, and can instruct the IDE how to process this code.
//Este es el que se ejecuta
//Para la conexión son supabase se editó el archivo resources/applicationProperties
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

}
