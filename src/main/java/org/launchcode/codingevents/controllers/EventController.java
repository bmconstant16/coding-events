package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

@Controller
public class EventController {

    @RequestMapping(value= "events")
    public String getEvents(Model model) {
        HashMap<String, String> events = new HashMap<>();
        events.put("Coding Jamboree", "This is a fun coding event with dancing");
        events.put("Arch Coders", "St Louis area arch coders unite!");
        events.put("FOSS4G Coding", "Open source rules!");

        model.addAttribute("events", events);

        return "events/index";

    }
}
