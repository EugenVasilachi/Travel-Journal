package com.example.traveljournal.Model;

import android.graphics.drawable.Drawable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "trip_table")
public class Trip{
    @PrimaryKey(autoGenerate = true)
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String destination;
    @NotNull
    private String type;
    @NotNull
    private int price;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;
    @NotNull
    private float rate;
    @NotNull
    private Drawable image;

    public void setName(String name) {
        this.name = name;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public float getRate() {
        return rate;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Trip(String name, String destination, String type, int price, String startDate, String endDate, float rate, Drawable image) {
        this.name = name;
        this.destination = destination;
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
        this.image = image;
    }
}
