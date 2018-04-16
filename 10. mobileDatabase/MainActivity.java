package com.android.manmeet.mobiledatabase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase myDB;
    private MySQLiteHelper myDBHelper;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        listView = (ListView) findViewById(R.id.listview);
        myDBHelper = new MySQLiteHelper(this);
        myDB = myDBHelper.getWritableDatabase();
        displayStudents();
    }

    public List<String> getStudents() {
        List<String> students = new ArrayList<>();
        Cursor cursor = myDB.query(MySQLiteHelper.TABLE_NAME,
                MySQLiteHelper.TABLE_COLUMNS, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String stu = "";
            stu = stu + cursor.getString(MySQLiteHelper.COLNO_STUDENT_NAME);
            stu = stu + "   " + String.valueOf(cursor.getInt(MySQLiteHelper.COLNO_ROLL_NO));
            stu = stu + "   " + cursor.getString(MySQLiteHelper.COLNO_BRANCH);
            students.add(stu);
            cursor.moveToNext();
        }
        cursor.close();
        return students;
    }

    public void displayStudents() {
        List<String> studentEntries = getStudents();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentEntries);
        listView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myDB.close();
    }
}
