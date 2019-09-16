package com.d2iq.helloworld.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GreetingController {
    @Value("${app.defaultName}")
    private String defaultName;

    @GetMapping("/")
    public String index(@RequestParam(value="name", required=false) String name, Model model) {
        model.addAttribute("name", name == null ? defaultName : name);
        return "index";
    }
}
