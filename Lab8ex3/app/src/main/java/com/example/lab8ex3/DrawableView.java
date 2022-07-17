package com.example.lab8ex3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawableView extends View {
    Paint paint = new Paint();
    int gCenterX,gCenterY,gRadius;

    public DrawableView(Context context) {
        super(context);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(gCenterX,gCenterY,gRadius,paint);
    }
    @Override
    public boolean onTouchEvent (MotionEvent event){
        int pointerCount = event.getPointerCount();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_POINTER_DOWN:
                if (pointerCount ==2) {
                    int gTouchX1 = (int) event.getX(0);
                    int gTouchY1 = (int) event.getY(0);
                    int gTouchX2 = (int) event.getX(1);
                    int gTouchY2 = (int) event.getY(1);

                    gCenterX = (gTouchX2 + gTouchX1)/2;
                    gCenterY = (gTouchY2 + gTouchY1)/2;
                    gRadius = (int)(Math.pow(gTouchX2-gTouchX1,2)+Math.pow(gTouchY2-gTouchY1,2)/2);

                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
