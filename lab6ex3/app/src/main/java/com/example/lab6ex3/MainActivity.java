package com.example.lab6ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    TextView textViewUrl,textViewResult;
    Button buttonGo;
    ListView list;
    String [] listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewUrl =findViewById(R.id.textViewUrl);
        textViewResult =findViewById(R.id.textViewResult);
        buttonGo =findViewById(R.id.buttonGo);
        list =findViewById(R.id.listViewCode);
        buttonGo.setOnClickListener(this);
        StrictMode.ThreadPolicy tp = StrictMode.ThreadPolicy.LAX;
        StrictMode.setThreadPolicy(tp);
    }
    public void onClick(View view){
        InputStream inputStream = null;
        String result = "";
        URL url = null;
        try{
            url = new URL(textViewUrl.getText().toString());
            HttpURLConnection con =(HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.connect();

            inputStream = con.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while ((line=bufferedReader.readLine())!=null)
                result+=line;
            inputStream.close();

            JSONObject json = new JSONObject(result);
            JSONArray codeArray = json.getJSONArray("canpuses");
            listItems = new String[codeArray.length()];
            for (int i=0;i<codeArray.length();i++){
                listItems[i] = codeArray.getJSONObject(i).getString("code");
            }
            list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listItems));
            list.setOnItemClickListener(this);
        }catch (Exception e){
            textViewResult.setText(e.getMessage());
        }

    }
    public void onItemClick(AdapterView<?> a,View v,int position,long id){
        textViewResult.setText(listItems[position]+"selected.");
    }
}