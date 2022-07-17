package com.example.lab3ex1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first  created.*/
    private TextView tvUserName;
    private EditText etUserName;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*** binding the UI's controls defined in main.xml to Java Code ***/
        etUserName = findViewById(R.id.etUserName);
    }
    public void onClick(View v) {
        String userName = etUserName.getText().toString();
        Toast.makeText(getApplicationContext(), "Hello " + userName,
                Toast.LENGTH_SHORT).show();
    }
}
