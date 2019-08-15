package com.sxzwp;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.sxzwp")
public class Application {
	public static void main(String[] args){
		SpringApplication.run(Application.class,args);
	}
}
