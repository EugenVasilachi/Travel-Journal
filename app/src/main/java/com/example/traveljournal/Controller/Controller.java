package com.example.traveljournal.Controller;

import android.graphics.drawable.Drawable;

import com.example.traveljournal.Model.Profile;
import com.example.traveljournal.Model.Trip;

public class Controller {
    public Controller(Profile profile) {
        this.profile = profile;
    }

    private Profile profile;
    public void addTrip(String name, String destination,
                               String type, int price, String startDate,
                               String endDate, float rate , Drawable image) {
        Trip trip = new Trip(name, destination, type, price, startDate, endDate, rate, image);
       profile.addTrip(trip);
    }
}
