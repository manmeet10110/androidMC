package com.android.manmeet.androidclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AnalogClock;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {

    private AnalogClock analogClock;
    private TextClock textClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analogClock = (AnalogClock) findViewById(R.id.analog_clock);
        textClock = (TextClock) findViewById(R.id.digital_clock);

    }
}
