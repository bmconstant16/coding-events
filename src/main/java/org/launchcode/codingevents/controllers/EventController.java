package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.launchcode.codingevents.models.Event;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<String> events = new ArrayList<>();
//    private static List<Event> events = new ArrayList<>();
    //list is coding to an interface type

    @GetMapping
    public String getEvents(Model model) {
//        List<String> events = new ArrayList<>();
//        events.add("Coding Jamboree");
//        events.add("Arch Coders");
//        events.add("FOSS4G Coding");
//        model.addAttribute("events", events);
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";

    }

    //lives at /events
    @GetMapping(value = "create")
    public String renderCreateEvent(Model model){
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription) {
//        events.add(eventName);
        EventData.add(new Event(eventName, eventDescription));
        //events.add(new Event(eventName, eventDescription));
        return "redirect:"; //300-level http response and instructs browser to redirect:/events

    }
}
