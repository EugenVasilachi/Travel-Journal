package com.example.traveljournal.Controller.recicler_view;
import android.annotation.SuppressLint;
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        Trip currentTrip = trips.get(position);

        String id = Integer.toString(currentTrip.getId());
        holder.getTripId().setText(id);

        String idBookmark = Integer.toString(currentTrip.getId());
        holder.getBookmark().setText(idBookmark);

        int favourite = currentTrip.getFavourite();
        if(favourite == 1) {
            holder.getBookmark().setButtonDrawable(R.drawable.ic_baseline_favorite_24);
        }

        if(!currentTrip.getName().isEmpty())
        holder.getTextViewName().setText(currentTrip.getName());
        else
            holder.getTextViewName().setText("Trip name");

        if(!currentTrip.getDestination().isEmpty())
        holder.getTextViewDestination().setText(currentTrip.getDestination());
        else
            holder.getTextViewDestination().setText("Destination");

        String pret=Float. toString(currentTrip.getPrice()) + "€";
        holder.getTextViewPrice().setText(pret);

        ImageView imageView = holder.getImageView().findViewById(R.id.imageViewCard);
        if(!currentTrip.getImage().isEmpty()) {
            Picasso.get().load(currentTrip.getImage()).into(imageView);
            Picasso.get().load(currentTrip.getImage()).error(R.drawable.default_img1).into(imageView);
        }
        else imageView.setImageResource(R.drawable.default_img1);
        holder.setImageView(imageView);
    }

    @Override
    public int getItemCount() {
        return trips.size();
    }
}
