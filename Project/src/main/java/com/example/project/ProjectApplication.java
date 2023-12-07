package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {
    public static boolean isSignedIn = false;
    public static void main(String[] args) {
        isSignedIn = false;
        SpringApplication.run(ProjectApplication.class, args);
    }

}
