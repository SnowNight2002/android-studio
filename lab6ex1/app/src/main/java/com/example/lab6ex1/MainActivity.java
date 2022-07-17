package com.example.lab6ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUrl;
    private TextView textViewGreeting;
    DownloadTask task = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUrl=findViewById(R.id.edTextUrl);
        textViewGreeting=findViewById(R.id.textViewGreeting);
    }

    private class  DownloadTask extends AsyncTask<String,Integer,String>{
        @Override
        protected String doInBackground(String... values){
            InputStream inputStream=null;
            String resuit="";
            URL url=null;
            try {
                url=new URL(values[0]);
                HttpURLConnection con =(HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                inputStream = con.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

                String line = "";
                while ((line=bufferedReader.readLine())!=null)
                    resuit+=line;
                Log.d("doInBackground","get data complete");
                inputStream.close();

                }catch(Exception e){
                e.printStackTrace();
                resuit=e.getMessage();
            }
            return resuit;
        }
        @Override
        protected void onPostExecute(String result){
            textViewGreeting.setText(result);
        }
    }
    public void getGreeting(View view){
        if (task == null|| task.getStatus().equals(AsyncTask.Status.FINISHED)){
            textViewGreeting.setText("Loading...");
            task=new DownloadTask();
            task.execute(editTextUrl.getText().toString());

        }
    }
    public void changeRed(View view){
        textViewGreeting.setBackgroundColor(Color.RED);
    }
    public void changeGreen(View view){
        textViewGreeting.setBackgroundColor(Color.GREEN);
    }
}
