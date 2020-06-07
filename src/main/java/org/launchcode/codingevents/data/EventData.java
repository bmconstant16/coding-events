package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    //a place to put events- a data structure of some type
    //once data is created, the map itself can't change- the data inside can, but not the map
    private static final Map<Integer, Event> events = new HashMap<>();


    //need behaviors to get all events
    public static Collection<Event> getAll(){
        return events.values();

        //collection is an interface
    }

    //get a single event
    public static Event oneEvent(int id){
        return events.get(id);
    }

    //add an event to the collection
    public static void add(Event event){
        events.put(event.getId(), event);
    }

    // remove an event
    public static void remove(int id){
        events.remove(id);
    }


}
