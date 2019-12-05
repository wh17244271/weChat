package com.suypower.venus.platform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages = {"com.suypower.venus"})
@SpringBootConfiguration
@EnableScheduling
@EnableAsync
public class EtlServerApplication {

    public static Logger logger = LoggerFactory.getLogger(EtlServerApplication.class);


    public static void main(String[] args) {
          SpringApplication.run(EtlServerApplication.class,args);
    }
}
