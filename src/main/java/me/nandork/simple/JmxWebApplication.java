package me.nandork.simple;

import me.nandork.simple.controller.SimpleController;
import org.springframework.boot.SpringApplication;

public class JmxWebApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleController.class, args);
    }
}