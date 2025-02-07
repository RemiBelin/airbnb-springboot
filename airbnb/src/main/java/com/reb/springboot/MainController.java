package com.reb.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Dont use RestController as this method is mapping to a static file not a JSON
public class MainController {

    @GetMapping(value={"/"})
    public String index() {
        return "index.html";
    }

    @GetMapping("/login1")
    public String login() {
        return "login1.html";
    }

}
