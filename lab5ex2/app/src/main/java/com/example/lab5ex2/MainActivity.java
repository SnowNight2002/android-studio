package com.example.lab5ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE =3434;
    private int trial = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickHandler (View view){
        EditText etName = findViewById(R.id.etName);
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("name",etName.getText().toString());
        ++trial;
        i.putExtra("trial",""+trial);
        startActivityForResult(i,REQUEST_CODE);
    }
    protected void onActivityResult(int requestCod,int resultCode,Intent data){
        if (resultCode == RESULT_OK && requestCod == REQUEST_CODE){
            if (data.hasExtra("playTime")){
                TextView tv = findViewById(R.id.tvMsg);
                String playTime = data.getExtras().getString("playTime");
                tv.setText("You have played " + playTime +" Second(s).");


            }
        }


    }
}