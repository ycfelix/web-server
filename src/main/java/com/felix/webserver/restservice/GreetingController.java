package com.felix.webserver.restservice;

import java.util.concurrent.atomic.AtomicLong;

import com.felix.webserver.Model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong id = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")
                                     String name) {
        return new Greeting(id.incrementAndGet(), String.format(template, name));
    }
}
