package com.example.traveljournal.View.recicler_view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.R;

public class TripViewHolder extends RecyclerView.ViewHolder{

    private final TextView textViewName, textViewDestination;

    public TripViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewDestination = itemView.findViewById(R.id.textViewDestination);
    }

    public TextView getTextViewName() {
        return textViewName;
    }

    public TextView getTextViewDestination() {
        return textViewDestination;
    }


}
