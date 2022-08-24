package eu.fooder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
