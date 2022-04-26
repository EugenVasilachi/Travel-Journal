package com.example.traveljournal.Controller;

import com.example.traveljournal.Model.Profile;
import com.example.traveljournal.Model.Trip;

public class Controller {

    public static void addTrip(String name, String destination, float price) {
        Trip trip = new Trip(name, destination, price);
        Profile profile = new Profile("Eugen", "vas@gmail.com", "12345", null);
        profile.addTrip(trip);
    }
}
