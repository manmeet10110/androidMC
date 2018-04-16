package com.android.manmeet.androidcalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleCalendar simpleCalendar = (SimpleCalendar) findViewById(R.id.square_day);

        simpleCalendar.setUserCurrentMonthYear(2, 2017);

        simpleCalendar.setCallBack(new SimpleCalendar.DayClickListener() {
            @Override
            public void onDayClick(View view) {

            }
        });
    }
}
