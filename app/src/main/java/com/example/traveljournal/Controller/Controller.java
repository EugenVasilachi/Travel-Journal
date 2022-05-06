package com.example.traveljournal.Controller;
import android.graphics.drawable.Drawable;
import com.example.traveljournal.Model.Profile;
import com.example.traveljournal.Model.Trip;
import java.io.Serializable;

public class Controller implements Serializable{
    private Profile profile;

    public Controller(Profile profile) {

        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void addTrip(String name, String destination,
                               String type, int price, String startDate,
                               String endDate, float rate , Drawable image) {
        Trip trip = new Trip(name, destination, type, price, startDate, endDate, rate, image);
       profile.addTrip(trip);
    }
}
