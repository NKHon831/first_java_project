package com.testing.first_java_app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/")
    public String homePage() {
        return "Hello Player. This is my first java application";
    }
}
