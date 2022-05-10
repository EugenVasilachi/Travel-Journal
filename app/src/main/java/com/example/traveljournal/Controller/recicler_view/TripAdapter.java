package com.example.traveljournal.Controller.recicler_view;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.traveljournal.Model.Trip;
import com.example.traveljournal.R;
import com.squareup.picasso.Picasso;

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
        String s=Float. toString(currentTrip.getPrice()) + "€";
        holder.getTextViewPrice().setText(s);
        ImageView imageView = holder.getImageView().findViewById(R.id.imageViewCard);
        Picasso.get().load(currentTrip.getImage()).into(imageView);
        Picasso.get().load(currentTrip.getImage()).error(R.drawable.default_img1).into(imageView);
        holder.setImageView(imageView);
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }
}
