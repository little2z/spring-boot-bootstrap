package com.xyl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutdownController {

    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping("/shutdownContext")
    public String closeContext(){

        ((ConfigurableApplicationContext)applicationContext).close();

        return "true";
    }

}
