package com.xyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class ShutdownConfig {

    @Bean
    public TerminateBean terminateBean(){
        return new TerminateBean();
    }

    public static class TerminateBean {

        @PreDestroy
        public void onDestroy() throws Exception {
            System.out.println("My Spring Container is destroyed!");
        }
    }
}
