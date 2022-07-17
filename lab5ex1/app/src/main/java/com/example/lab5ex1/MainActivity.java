package com.example.lab5ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    String[] items = {"Send SMS","Search on Google","Wikionary","Wikipedia","Show Map", "Show Streep View","Show Contact"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));

    }
    public void onListItemClick(ListView parent, View v,int position,long id){
        Intent intent = null;
        switch (position){
            case 0:
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:93479123"));
                intent.putExtra("sas_body","my message");
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"IVE");
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://en.wiktionary.org/wiki/"+"mobile"));
                startActivity(intent);
                break;
            case 3:
                String uri="http://en.wiktionary.org/wiki/"+"Android";
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
                startActivity(intent);
                break;
            case 4:
               intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:22.3199,114.036"));
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("google.streetview:cbll=22.3192,114.176&cbp=1,200,,0,1"));
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people"));
                startActivity(intent);
                break;
        }
    }
}