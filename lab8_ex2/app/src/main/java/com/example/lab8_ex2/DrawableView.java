package com.example.lab8_ex2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;


public class DrawableView extends View {
    Path path = new Path();
    Paint paint = new Paint();

    public DrawableView(Context context) {
        super(context);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }
    public boolean onTouchEvent(MotionEvent event){
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            path.reset();
            path.setLastPoint(event.getX(),event.getY());

        }else if(event.getAction()==MotionEvent.ACTION_MOVE|| event.getAction()==MotionEvent.ACTION_UP){
            path.rLineTo(event.getX(),event.getY());
            path.setLastPoint(event.getX(),event.getY());
        }
        invalidate();
        return true;
    }

}