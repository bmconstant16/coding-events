package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    @RequestMapping(value= "events")
    public String getEvents(Model model) {
        List<String> events = new ArrayList<>();
        events.add("Coding Jamboree");
        events.add("Arch Coders");
        events.add("FOSS4G Coding");

        model.addAttribute("events", events);

        return "events/index";

    }
}
