package com.example.lab8_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    DrawableView drawableView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawableView = new DrawableView(this);
        setContentView(drawableView);
        drawableView.requestFocus();
    }
}