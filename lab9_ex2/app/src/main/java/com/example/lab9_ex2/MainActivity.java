package com.example.lab9_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView latitude,longitude,mAddress;
    Geocoder geocoder = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        mAddress = findViewById(R.id.address);
        geocoder = new Geocoder(this);

    }
    public void onClick(View view){
        try {
            List<Address> addresses =geocoder.getFromLocationName(input.getText().toString(),1);
            if(addresses!=null&&addresses.size()>0){
                Address address = addresses.get(0);

                String addressText =String.format("%s,%s",address.getAddressLine(0),address.getCountryCode());
                latitude.setText("Latitude: " + address.getLatitude());
                longitude.setText("Longitude: " + address.getLongitude());
                mAddress.setText("Address: " + addressText);
            }

        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
    }
}