package com.example.lab3ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox cbCream, cbSugar;
    private RadioGroup rgCoffeeType;
    private RadioButton rbLatte, rbMocha, rbCappuccino ;
    private Button btPay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbLatte=findViewById(R.id.rbLatte);
        rbMocha=findViewById(R.id.rbMocha);
        rbCappuccino=findViewById(R.id.rbCappuccino);
        cbCream=findViewById(R.id.cbCream);
        cbSugar=findViewById(R.id.cbSugar);
    }
    public void btPayOnClick(View v) {
        String output ="";
        if (rbLatte.isChecked()){
            output += rbLatte.getText().toString()+" " ;
        }else if(rbMocha.isChecked()){
            output += rbMocha.getText().toString()+" " ;
        }else if(rbCappuccino.isChecked()){
            output += rbCappuccino.getText().toString()+" " ;
        }
        output += "Coffee";

    if(cbCream.isChecked()){
        output += " & " + cbCream.getText().toString();
    }
    if(cbSugar.isChecked()){
        output += " & " + cbSugar.getText().toString();
    }


    Toast.makeText(getApplicationContext(),output,Toast.LENGTH_SHORT).show();
}
}
