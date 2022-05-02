package com.example.traveljournal.Model;

public class Trip {
    // to be continued
    // picture
    // rating
    private String name;
    private String destination;
    //private float price;


    public Trip(String name, String destination) {
        this.name = name;
        this.destination = destination;
        //this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }
}
