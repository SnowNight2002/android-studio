package com.example.lab3ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private TextView selection;
    private ListView list;
    private String[] items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = findViewById(R.id.selection);
        list = findViewById(R.id.list);
        items = getResources().getStringArray(R.array.planets_array);

        list.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items));
        list.setOnItemClickListener(this);


        }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        selection.setText("Planet -" + items[position]);
    }
}