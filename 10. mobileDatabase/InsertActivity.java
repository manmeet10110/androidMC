package com.android.manmeet.mobiledatabase;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    private EditText name, roll, branch;
    private Button add;
    private SQLiteDatabase myDB;
    private MySQLiteHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = (EditText) findViewById(R.id.student_name);
        roll = (EditText) findViewById(R.id.roll_no);
        branch = (EditText) findViewById(R.id.branch);
        add = (Button) findViewById(R.id.add);

        myDBHelper = new MySQLiteHelper(this);
        myDB = myDBHelper.getWritableDatabase();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudent();
                startActivity(new Intent(InsertActivity.this, MainActivity.class));
            }
        });
    }

    private void addStudent(){
        ContentValues myValues=new ContentValues(2);

        myValues.put(MySQLiteHelper.TABLE_COLUMNS[1], name.getText().toString());
        myValues.put(MySQLiteHelper.TABLE_COLUMNS[2], Integer.parseInt(String.valueOf(roll.getText())));
        myValues.put(MySQLiteHelper.TABLE_COLUMNS[3], branch.getText().toString());
        myDB.insert(MySQLiteHelper.TABLE_NAME, null, myValues);
    }


}
