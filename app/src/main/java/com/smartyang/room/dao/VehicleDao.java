package com.smartyang.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.smartyang.room.model.Vehicle;

import java.util.List;

@Dao
public interface VehicleDao {
    @Query("Select * from vehicles")
    LiveData<List<Vehicle>> getVehicles();

    @Insert
    void addVehicle(Vehicle vehicle);

    @Query("select * from vehicles where id=:v_id")
    Vehicle getThisVehicle(int v_id);

    @Update
    void updateVehicle(Vehicle v);

    @Delete
    void deleteVehicle(Vehicle vehicle);


}
