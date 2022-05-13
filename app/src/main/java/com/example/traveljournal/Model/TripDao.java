package com.example.traveljournal.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TripDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Trip trip);

    @Query("SELECT * FROM trip_table_prezentare ORDER BY id ASC")
    LiveData<List<Trip>> getTrips();

    @Query("SELECT * FROM trip_table_prezentare WHERE favourite=1 ORDER BY id ASC")
    LiveData<List<Trip>> getFavouriteTrips();

    @Query("SELECT * FROM trip_table_prezentare WHERE id = :id")
    Trip loadTrip(int id);

    @Query("SELECT * FROM trip_table_prezentare")
    List<Trip> getAllTrips();

    @Query("UPDATE trip_table_prezentare SET favourite = :favourite WHERE id = :id")
    void updateFavourite(int id, int favourite);

    @Query("SELECT * FROM trip_table_prezentare WHERE favourite=1 ORDER BY id ASC")
    List<Trip> getAllFavouriteTrips();
}
