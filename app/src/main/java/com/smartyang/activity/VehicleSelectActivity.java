package com.smartyang.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.smartyang.R;
import com.smartyang.databinding.ActivityVehicleSelectBinding;

public class VehicleSelectActivity extends AppCompatActivity {

    private ActivityVehicleSelectBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_vehicle_select);

        b.img2WheelBike.setOnClickListener(v -> {
            startActivity(new Intent(this, AddSensorsActivity.class));
        });

    }
}