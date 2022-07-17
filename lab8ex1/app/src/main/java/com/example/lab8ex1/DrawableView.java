package com.example.lab8ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class DrawableView extends View {
    Paint paint = new Paint();
    float x1,y1,x2,y2;
    public DrawableView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawRect(x1,y1,x2,y2, paint);
    }
    public boolean onTouchEvent(MotionEvent event){
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            x1 = event.getX();
            y1 = event.getY();
            x2 = event.getX();
            y2 = event.getY();
        } else if (event.getAction()==MotionEvent.ACTION_MOVE){
            x2 = event.getX();
            y2 = event.getY();
        }else if (event.getAction()==MotionEvent.ACTION_UP){
            x2 = event.getX();
            y2 = event.getY();
        }
        invalidate();
        return true;
    }

}