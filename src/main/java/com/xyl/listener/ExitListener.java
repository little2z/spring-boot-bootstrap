package com.xyl.listener;

import org.springframework.boot.ExitCodeEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ExitListener {


    @Bean
    public ExitEventListener exitEventListener(){
        return new ExitEventListener();
    }

    private static class ExitEventListener{

        @EventListener
        public void exitEvent(ExitCodeEvent event) {
            System.out.println("My Customer Exit code: " + event.getExitCode());
        }

    }

}
