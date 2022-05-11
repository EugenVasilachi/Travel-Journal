package com.example.traveljournal.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface TripDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)  // cand se insereaza acelasi cuvant, il ignora (nu-l mai insereaza)
    void insert(Trip trip);

    @Query("SELECT * FROM trip_table_test5 ORDER BY id ASC")
    LiveData<List<Trip>> getTrips();

    /*@Query("SELECT * FROM trip_table_test5 WHERE favourite=1 ORDER BY id ASC")
    LiveData<List<Trip>> getFavouriteTrips();*/
}
