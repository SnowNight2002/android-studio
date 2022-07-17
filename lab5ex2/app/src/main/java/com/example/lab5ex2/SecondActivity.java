package com.example.lab5ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    private  long startTime = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvTrial = findViewById(R.id.tvTrial);
        startTime = System.currentTimeMillis();

        Intent intent =getIntent();
        tvName.setText(intent.getStringExtra("name"));
        tvName.setText(intent.getStringExtra("trial"));

    }
    public void onFinish(View view){
        finish();
    }
    public void finish(){
        long finishTime = System.currentTimeMillis();
        int elapsedTime =(int)(finishTime - startTime)/1000;
        Intent result = new Intent();
        result.putExtra("playTime",elapsedTime+"");
        setResult(RESULT_OK,result);
        super.finish();
    }


















}