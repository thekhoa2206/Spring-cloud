package com.sapo.servicetwo.controller;

import com.sapo.servicetwo.entity.User;
import com.sapo.servicetwo.services.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private final MyService myService;

    public Controller(MyService myService) {
        this.myService = myService;
    }

    @GetMapping
    public List<User> test() {
        return myService.findAll();
    }
}
