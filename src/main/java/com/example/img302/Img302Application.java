package com.example.img302;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableCaching
@EnableJpaAuditing// 自动更新时间
@SpringBootApplication
public class Img302Application {

    public static void main(String[] args) {
        SpringApplication.run(Img302Application.class, args);
    }

}
