package org.launchcode.codingevents.controllers;


import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        model.addAttribute(new Event());
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent,
                              Errors errors, Model model) {

        if (errors.hasErrors()){
            model.addAttribute("title", "Create Event");
//            model.addAttribute("errorMsg", "Bad data!");
            return "events/create";
        }
//        events.add(eventName);
        EventData.add(newEvent);
        //events.add(new Event(eventName, eventDescription));
        return "redirect:"; //300-level http response and instructs browser to redirect:/events

        //old params we removed and replaced after model binding @RequestParam String eventName, @RequestParam String eventDescription
        //EventData.add(new Event(eventN(ame, eventDescription));
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventFrom(@RequestParam(required = false) int []eventIds){

        if (eventIds != null) {
            for (int id : eventIds ) {
                EventData.remove(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        model.addAttribute("event", EventData.oneEvent(eventId));
        model.addAttribute("title", "Edit Event " + EventData.oneEvent(eventId).getName() + " id= " + eventId);

        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description){
        EventData.oneEvent(eventId).setName(name);
        EventData.oneEvent(eventId).setDescription(description);

        return "redirect:";
    }

}
