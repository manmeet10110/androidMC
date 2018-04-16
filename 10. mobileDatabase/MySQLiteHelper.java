package com.android.manmeet.mobiledatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "students";
    public static final int COLNO_STUDENT_NAME = 1;
    public static final int COLNO_ROLL_NO = 2;
    public static final int COLNO_BRANCH = 3;
    public static final String[] TABLE_COLUMNS =
            new String[]{"_id", "student_name", "roll_no", "branch"};

    private static final String DBFILENAME = "students.db";
    private static final int DBVERSION = 1;
    private static final String INITIAL_SCHEMA =
            "create table students (" +
                    "_id integer primary key autoincrement," +
                    "student_name varchar(100) not null," +
                    "roll_no integer not null," +
                    "branch varchar(30) not null" +
                    ")";

    public MySQLiteHelper(Context context) {
        super(context, DBFILENAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(INITIAL_SCHEMA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
