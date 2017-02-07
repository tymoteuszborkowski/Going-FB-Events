package pl.tymoteuszborkowski.going.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tymoteuszborkowski.going.model.Event;
import pl.tymoteuszborkowski.going.repositories.EventRepository;
import pl.tymoteuszborkowski.going.services.FacebookService;

@Controller
public class EventController {

    @Autowired
    private FacebookService facebookService;

    @Autowired
    private EventRepository eventRepository;


    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/saved_index")
    public String saved(){
        return "saved_index";
    }

    @RequestMapping(value = "/444134282584226")
    public String melech(){
        Event event = facebookService.getEventById("444134282584226");
        eventRepository.save(event);

        return "redirect:/saved_index";
    }


    @RequestMapping(value = "/144699732700589")
    public String efdemin(){
        Event event = facebookService.getEventById("144699732700589");
        eventRepository.save(event);

        return "redirect:/saved_index";
    }




}
