package com.example.lab3ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbAdd,rbSub,rbMul,rbDiv;
    private Button btCompute;
    private EditText etNum1,etNum2;
    private TextView tvAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbAdd=findViewById(R.id.rbAdd);
        rbSub=findViewById(R.id.rbSub);
        rbMul=findViewById(R.id.rbMul);
        rbDiv=findViewById(R.id.rbDiv);
        btCompute=findViewById(R.id.btCompute);
        etNum1=findViewById(R.id.etNum1);
        etNum2=findViewById(R.id.etNum2);
        tvAns=findViewById(R.id.tvAns);
    }
    public void Compute(View view){
    double value1 = Double.parseDouble(etNum1.getText().toString());
    double value2 = Double.parseDouble(etNum2.getText().toString());

    if(rbAdd.isChecked()){
        tvAns.setText("Anser = "+(value1+value2));
    }
    else if(rbSub.isChecked()){
        tvAns.setText("Anser = "+(value1-value2));
    }
    else if(rbMul.isChecked()){
        tvAns.setText("Anser = "+(value1*value2));
    }
    else if(rbDiv.isChecked()){
        tvAns.setText("Anser = "+(value1/value2));
    }
    }
}