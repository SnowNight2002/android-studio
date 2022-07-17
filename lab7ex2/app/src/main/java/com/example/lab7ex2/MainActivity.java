package com.example.lab7ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    Button btnAlarm;
    boolean alarm_is_on;
    AlarmView alarmView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        alarm_is_on = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.linearLayout1);
        btnAlarm = findViewById(R.id.btnAlarm);

        alarmView = new AlarmView(MainActivity.this);
        layout.addView(alarmView);
    }

    public void btnAlarm_click(View v){
        alarm_is_on = !alarm_is_on;

        if (alarm_is_on){
            btnAlarm.setText("Alarm Off");
            alarmView.invalidate();
        } else {
            btnAlarm.setText("Alarm On");
//
        }
    }

    public class AlarmView extends View {

        int rColor[] = {Color.YELLOW, Color.BLACK, Color.RED};
        int i;
        public AlarmView(Context context) {
            super(context);
            i = 0;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.BLACK);
            Paint paint = new Paint();
            paint.setAntiAlias(true);

            i++;
            i = i % rColor.length;

            paint.setColor(Color.WHITE);
            canvas.drawCircle(getWidth()/2, 200, 65, paint);
            paint.setColor(rColor[i]);
            canvas.drawCircle(getWidth()/2, 200, 60, paint);

            if (alarm_is_on) {
                this.postInvalidateDelayed(1000);
            }

        }
    }
}
