package com.example.appfarm;

import com.example.appfarm.model.Dog;
import com.example.appfarm.repository.DogRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppfarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppfarmApplication.class, args);
    }	
}