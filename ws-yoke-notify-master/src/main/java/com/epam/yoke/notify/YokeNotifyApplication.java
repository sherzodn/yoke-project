package com.epam.yoke.notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class YokeNotifyApplication {

  public static void main(String[] args) {
    SpringApplication.run(YokeNotifyApplication.class, args);
  }

}
