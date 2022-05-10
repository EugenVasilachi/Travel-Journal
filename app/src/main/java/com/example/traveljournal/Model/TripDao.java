package com.example.traveljournal.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TripDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)  // cand se insereaza acelasi cuvant, il ignora (nu-l mai insereaza)
    void insert(Trip trip);

    @Query("SELECT * FROM trip_table ORDER BY id ASC")
    LiveData<List<Trip>> getTrips();
}
