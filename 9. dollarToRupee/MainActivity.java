package com.android.manmeet.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText dollar, rupee;
    private TextWatcher dollarWatcher, rupeeWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dollar = (EditText) findViewById(R.id.dollar);
        rupee = (EditText) findViewById(R.id.rupee);

        dollarWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0 && !String.valueOf(charSequence).equals("-")) {
                    float dol = Float.parseFloat(String.valueOf(charSequence));
                    float rup = (float) (dol * 64.92);
                    rupee.setText(String.valueOf(rup));
                }
                else if(charSequence.length()==0){
                    rupee.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        rupeeWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0 && !String.valueOf(charSequence).equals("-")) {
                    float rup = Float.parseFloat(String.valueOf(charSequence));
                    float dol = (float) (rup / 64.92 );
                    dollar.setText(String.valueOf(dol));
                }
                else if(charSequence.length()==0){
                    dollar.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };

        dollar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    dollar.addTextChangedListener(dollarWatcher);
                }
                else{
                    dollar.removeTextChangedListener(dollarWatcher);
                }
            }
        });

        rupee.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    rupee.addTextChangedListener(rupeeWatcher);
                }
                else{
                    rupee.removeTextChangedListener(rupeeWatcher);
                }
            }
        });
    }
}

