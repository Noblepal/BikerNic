package com.smartyang.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.smartyang.R;
import com.smartyang.databinding.ActivityMainBinding;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    private BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) {
            b.statusBluetoothTv.setText("Bluetooth is not available");
        } else {
            b.statusBluetoothTv.setText("Bluetooth is available");
        }

        //set image according to bluetooth status(on/off)
        if (bluetoothAdapter.isEnabled()) {
            b.bluetoothIv.setImageResource(R.drawable.ic_bt_on);
        } else {
            b.bluetoothIv.setImageResource(R.drawable.ic_bt_off);
        }

        b.onBtn.setOnClickListener(v -> {
            if (!bluetoothAdapter.isEnabled()) {
                showToast("Turning On Bluetooth...");
                //intent to on bluetooth
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, REQUEST_ENABLE_BT);
            } else {
                showToast("Bluetooth is already on.");
            }
        });

        b.discoverableBtn.setOnClickListener(v -> {
            if (!bluetoothAdapter.isDiscovering()) {
                showToast("Making Your Device Discoverable");
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(intent, REQUEST_DISCOVER_BT);
            }
        });
        b.offBtn.setOnClickListener(v -> {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
                showToast("Turning Bluetooth Off");
                b.bluetoothIv.setImageResource(R.drawable.ic_bt_off);
            } else {
                showToast("Bluetooth is already off");
            }
        });

        b.pairedBtn.setOnClickListener(v -> {
            if (bluetoothAdapter.isEnabled()) {
                b.pairedTv.setText("Paired Devices");
                Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
                for (BluetoothDevice device : devices) {
                    b.pairedTv.append("\nDevice: " + device.getName() + ", " + device);
                }
            } else {
                //bluetooth is off so can't get paired devices
                showToast("Turn on bluetooth to get paired devices");
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode) {
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK) {
                    //bluetooth is on
                    b.bluetoothIv.setImageResource(R.drawable.ic_bt_on);
                    showToast("Bluetooth is on");
                } else {
                    //user denied to turn bluetooth on
                    showToast("could't on bluetooth");
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}