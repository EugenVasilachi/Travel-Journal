package com.example.traveljournal.Controller.recicler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.R;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripViewHolder>{

    private List<Trip> trips;

    public TripAdapter(List<Trip> trips) {
        this.trips = trips;
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip, parent, false);
        return new TripViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip currentTrip = trips.get(position);
        holder.getTextViewName().setText(currentTrip.getName());
        holder.getTextViewDestination().setText(currentTrip.getDestination());
        String s=Float. toString(currentTrip.getPrice());
        holder.getTextViewPrice().setText(s);
        holder.getImageView().setImageDrawable(currentTrip.getImage());
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }
}
