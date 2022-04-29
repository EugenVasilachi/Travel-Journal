package com.example.traveljournal.Model;

import java.util.List;

public class Profile {
    private String name;
    private String email;
    private String password;
    private List<Trip> trips;
    private List<Trip> favouriteTrips;

    public Profile(String name, String email, String password, List<Trip> trips) {
        this(name, email, password, trips, null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile(String name, String email, String password, List<Trip> trips, List<Trip> favouriteTrips) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.trips = trips;
        this.favouriteTrips = favouriteTrips;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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
