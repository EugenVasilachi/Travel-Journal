package com.example.traveljournal.Controller;

import android.widget.ImageView;

import com.example.traveljournal.Model.Profile;
import com.example.traveljournal.Model.Trip;

public class Controller {

    public static void addTrip(String name, String destination,
                               String type, int price, String startDate,
                               String endDate, float rate , ImageView image) {
        Trip trip = new Trip(name, destination, type, price, startDate, endDate, rate, image);


    }
}
