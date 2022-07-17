package com.example.lab4ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    SQLiteDatabase db;
    String sql;
    Cursor cursor = null;
    String[] columns = {"mid", "name", "password", "age"};
    TextView tvData;
    String dataStrHeader = String.format("%4s %-12s %-9s %3s\n","Mid","Name", "Password", "Age");
    String dataStr;
    Button btnDBinitital, btnQuery, btnAction;

    public void findView(){
        tvData = (TextView) findViewById(R.id.data);
        btnDBinitital = (Button) findViewById(R.id.btnDBinitial);
        btnQuery = (Button) findViewById(R.id.btnQuery);
        btnAction = (Button) findViewById(R.id.btnAction);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        btnDBinitital.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
        btnAction.setOnClickListener(this);
        initialDB();
    }

    public void initialDB() {

        try {
            db = SQLiteDatabase.openDatabase("/data/data/com.example.lab4ex3/MemberDB", null, SQLiteDatabase.CREATE_IF_NECESSARY);
            sql = "DROP TABLE IF EXISTS MEMBER";
            db.execSQL(sql);
            sql = "CREATE TABLE Member (mid int PRIMARY KEY, name text, password text, age int);";
            db.execSQL(sql);

            db.execSQL("INSERT INTO Member(mid, name, password, age) values" + "(1001, 'Amy Carl', '12345', 16);");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values" + "(1002, 'Helen Leung', '88888', 25);");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values" + "(1003, 'Robert Chan', 'iloveu', 61);");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values" + "(1004, 'Carol Wong', 'peterpan', 33);");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values" + "(1005, 'Carman Wong', 'pooh', 44);");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values" + "(1006, 'John Chan', 'johnchan', 28);");
            db.execSQL("INSERT INTO Member(mid, name, password, age) values" + "(1007, 'Paul Lam', 'apple', 16);");

            Toast.makeText(this, "Table member is created and initialised", Toast.LENGTH_SHORT).show();

            cursor = db.rawQuery("SELECT * FROM Member", null);
            dataStr = dataStrHeader;
            while (cursor.moveToNext()) {
                int mid = cursor.getInt(cursor.getColumnIndex("mid"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                dataStr += String.format("%4d %-12s %-9s %3d\n",mid,name,password,age);
            }
            tvData.setText(dataStr);
            db.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnDBinitital)){
            initialDB();
        }
        else if(v.equals(btnQuery)){
            try {
                db = SQLiteDatabase.openDatabase("/data/data/com.example.lab4ex3/MemberDB", null, SQLiteDatabase.OPEN_READONLY);
                cursor = db.rawQuery("SELECT * FROM Member WHERE length(password) < 7 AND age > 20", null);

                dataStr = dataStrHeader;
                while (cursor.moveToNext()){
                    int mid = cursor.getInt(cursor.getColumnIndex("mid"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String password = cursor.getString(cursor.getColumnIndex("password"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    dataStr += String.format("%4d %-12s %-9s %3d\n",mid,name,password,age);
                }

                tvData.setText(dataStr);
                db.close();
            } catch (SQLiteException e){
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
        else if(v.equals(btnAction)){
            try {
                db = SQLiteDatabase.openDatabase("/data/data/com.example.lab4ex3/MemberDB", null, SQLiteDatabase.OPEN_READWRITE);

                sql = "INSERT INTO Member VALUES " + "(1008, 'Ronald Tang', 'ilovehk', 66)";
                db.execSQL(sql);

                sql = "UPDATE Member SET password = 'winnie' WHERE mid = 1005";
                db.execSQL(sql);

                sql = "DELETE FROM Member WHERE mid=1003";
                db.execSQL(sql);

                cursor = db.query("Member", columns, null, null, null, null, null);
                dataStr = dataStrHeader;
                while (cursor.moveToNext()){
                    int mid = cursor.getInt(cursor.getColumnIndex("mid"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String password = cursor.getString(cursor.getColumnIndex("password"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    dataStr += String.format("%4d %-12s %-9s %3d\n",mid,name,password,age);
                }

                tvData.setText(dataStr);
                db.close();
            }catch (SQLiteException e) {
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}