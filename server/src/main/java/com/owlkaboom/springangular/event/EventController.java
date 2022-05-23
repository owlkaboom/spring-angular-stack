package com.owlkaboom.springangular.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {

    @GetMapping
    public List<String> getEvents(){
        return List.of("a","b");
    }
}
