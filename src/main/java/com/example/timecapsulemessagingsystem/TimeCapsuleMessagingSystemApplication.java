package com.example.timecapsulemessagingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TimeCapsuleMessagingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimeCapsuleMessagingSystemApplication.class, args);
    }

}
