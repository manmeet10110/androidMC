package com.android.amrit.celciustofahrenheit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText celcius, fahrenheit;
    private TextWatcher celWatcher, fahrWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celcius = (EditText) findViewById(R.id.celcius);
        fahrenheit = (EditText) findViewById(R.id.fahrenheit);

        celWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0 && !String.valueOf(charSequence).equals("-")) {
                    float cel = Float.parseFloat(String.valueOf(charSequence));
                    float fahr = (float) ((cel * 1.8) + 32.0);
                    fahrenheit.setText(String.valueOf(fahr));
                }
                else if(charSequence.length()==0){
                    fahrenheit.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        fahrWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0 && !String.valueOf(charSequence).equals("-")) {
                    float fahr = Float.parseFloat(String.valueOf(charSequence));
                    float cel = (float) ((fahr - 32.0) / 1.8);
                    celcius.setText(String.valueOf(cel));
                }
                else if(charSequence.length()==0){
                    celcius.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        celcius.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    celcius.addTextChangedListener(celWatcher);
                }
                else{
                    celcius.removeTextChangedListener(celWatcher);
                }
            }
        });

        fahrenheit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    fahrenheit.addTextChangedListener(fahrWatcher);
                }
                else{
                    fahrenheit.removeTextChangedListener(fahrWatcher);
                }
            }
        });
    }
}
