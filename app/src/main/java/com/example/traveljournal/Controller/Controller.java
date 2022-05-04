package com.example.traveljournal.Controller;

import android.graphics.drawable.Drawable;

import com.example.traveljournal.Model.Trip;

public class Controller {

    public static void addTrip(String name, String destination,
                               String type, int price, String startDate,
                               String endDate, float rate , Drawable image) {
        Trip trip = new Trip(name, destination, type, price, startDate, endDate, rate, image);


    }
}
