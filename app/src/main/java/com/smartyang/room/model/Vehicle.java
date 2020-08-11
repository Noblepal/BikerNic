package com.smartyang.room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vehicles")
public class Vehicle {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String vehicle_type;

    private int wheel_count;

    private String vehicle_name;

    public Vehicle(int id, String vehicle_type, int wheel_count, String vehicle_name) {
        this.id = id;
        this.vehicle_type = vehicle_type;
        this.wheel_count = wheel_count;
        this.vehicle_name = vehicle_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public int getWheel_count() {
        return wheel_count;
    }

    public void setWheel_count(int wheel_count) {
        this.wheel_count = wheel_count;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }
}
