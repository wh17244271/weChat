package com.suypower.venus.bootstrap;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication(scanBasePackages = {"com.suypower.venus"})
@SpringBootConfiguration
@MapperScan("com.suypower.venus")
//@EnableScheduling
@EnableAsync
public class EtlServerApplication {

    public static Logger logger = LoggerFactory.getLogger(EtlServerApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(EtlServerApplication.class,args);
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SpringBoot Start Success");
    }
}
