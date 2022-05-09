package com.example.traveljournal.View.ui.addTrip;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.traveljournal.R;
import com.example.traveljournal.View.DrawerActivity;

public class AddTripFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_trip, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Da frate");
    }
}
