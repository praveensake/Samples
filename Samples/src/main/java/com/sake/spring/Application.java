package com.sake.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by sakez on 07/08/17
 * This class is a test spring boot application
 * In order to test this class, run the below main()
 * Go to a browser and enter the url: http://localhost:8080/greeting
 * The counter increments every time the page is refreshed
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}