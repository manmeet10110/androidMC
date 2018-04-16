package com.android.manmeet.metertocentimeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText meter, centimeter;
    private TextWatcher meterWatcher, centiWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meter = (EditText) findViewById(R.id.meter);
        centimeter = (EditText) findViewById(R.id.centimeter);

        meterWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0 && !String.valueOf(charSequence).equals("-")) {
                    float met = Float.parseFloat(String.valueOf(charSequence));
                    float cen = (float) (met * 100.0);
                    centimeter.setText(String.valueOf(cen));
                }
                else if(charSequence.length()==0){
                    centimeter.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        centiWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0 && !String.valueOf(charSequence).equals("-")) {
                    float cen = Float.parseFloat(String.valueOf(charSequence));
                    float met = (float) (cen / 100.0 );
                    meter.setText(String.valueOf(met));
                }
                else if(charSequence.length()==0){
                    meter.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        meter.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    meter.addTextChangedListener(meterWatcher);
                }
                else{
                    meter.removeTextChangedListener(meterWatcher);
                }
            }
        });

        centimeter.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    centimeter.addTextChangedListener(centiWatcher);
                }
                else{
                    centimeter.removeTextChangedListener(centiWatcher);
                }
            }
        });
    }
}

