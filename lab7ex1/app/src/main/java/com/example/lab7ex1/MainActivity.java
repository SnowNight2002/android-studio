package com.example.lab7ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Panel(this));
    }
    class Panel extends View {
        public Panel(Context context) {
            super(context);
        }
    String title ="Fund Portfolio";
    String items[]={"Financials","Properties","Utilities","Others"};
    float data[] = {52,25,11,12};
    int rColor[]={0xffff0000,0xffffff00,0xff32cd32,0xff880055};
    float cDegree =0;

    public void onDraw(Canvas c){
        super.onDraw(c);
        Paint paint =new Paint();
        paint.setColor(Color.WHITE);
        c.drawPaint(paint);

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        for (int i=0;i<data.length;i++){
            float drawDegree = data[i] * 360/100;

            paint.setColor(rColor[i]);
            RectF rec = new RectF(50,100,550,600);
            c.drawArc(rec,cDegree,drawDegree,true,paint);
            cDegree+=drawDegree;
        }
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(50);
        c.drawText(title,20,50,paint);

        int vSpace =getHeight()-100;
        paint.setTextSize(30);
        for(int i =items.length-1;i>=0;i--){
            paint.setColor(rColor[i]);
            c.drawRect(getWidth()-200,vSpace,getWidth()-180,vSpace+20,paint);

            paint.setColor(Color.BLACK);
            c.drawText(items[i],getWidth()-150,vSpace+30,paint);
            vSpace-=40;

        }
    }
    }
}