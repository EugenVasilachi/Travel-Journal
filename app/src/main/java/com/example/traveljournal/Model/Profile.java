package com.example.traveljournal.Model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Profile implements Serializable {
    private String name;
    private String email;
    private String password;
    private ArrayList<Trip> trips = new ArrayList<>();
    private ArrayList<Trip> favouriteTrips = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Profile(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.trips = new ArrayList<>();
        this.favouriteTrips = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }
}
