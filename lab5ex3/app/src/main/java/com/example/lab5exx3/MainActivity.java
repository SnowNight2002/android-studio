package com.example.lab5exx3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imgButton;
    ImageButton emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgButton = findViewById(R.id.imageButton);
        emailButton = findViewById(R.id.emailButton);

        registerForContextMenu(imgButton);
        registerForContextMenu(emailButton);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo ){
        super.onCreateContextMenu(menu,v,menuInfo);
        if(v == imgButton){
            menu.add(0,9,1,"Open");
            menu.add(0,10,2,"Save");
            menu.add(0,11,3,"Delete");
        }else if (v==emailButton){
            menu.add(0,12,1,"Send");
            menu.add(0,13,2,"Read");
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,1,"Edit");
        menu.add(0,2,2,"Exit");
        menu.add(0,3,3,"Undo");
        menu.add(0,4,4,"Help");
        menu.add(0,5,5,"Search");
        menu.add(0,6,6,"About");
        //menu.add(0,7,7,"File");

        SubMenu smFile = menu.addSubMenu(0,7,7,"File");
        smFile.add(0,71,1,"Open");
        smFile.getItem(0).setIcon(R.drawable.ic_baseline_open_in_new_24);
        smFile.add(0,72,2,"Save");
        smFile.getItem(1).setIcon(R.drawable.ic_baseline_save_24);
        smFile.add(0,73,3,"Open");
        smFile.getItem(2).setIcon(R.drawable.ic_baseline_delete_24);


        return  super.onCreateOptionsMenu(menu);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        return (applyMenuOption(item)||super.onOptionsItemSelected(item));
    }
    public  boolean applyMenuOption(MenuItem item){
        int menuItemId = item.getItemId();

        if (menuItemId == 6){
            openDialog();
        }else if (menuItemId==2){
            finish();
        }
        return  false;
    }
    public void  openDialog(){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage("This is an Options Menu");
        builder.setTitle("About");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();

    }
}
