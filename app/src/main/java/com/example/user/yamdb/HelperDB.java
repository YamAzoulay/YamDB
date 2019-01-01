package com.example.user.yamdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.user.yamdb.grades.ENGLISH;
import static com.example.user.yamdb.grades.MATH;
import static com.example.user.yamdb.grades.NAME;
import static com.example.user.yamdb.grades.TABLE_GRADES;
import static com.example.user.yamdb.personalInfo.KEY_ID;
import static com.example.user.yamdb.personalInfo.STUDENT_CLASS;
import static com.example.user.yamdb.personalInfo.STUDENT_ID;
import static com.example.user.yamdb.personalInfo.TABLE_PERSONALINFO;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;


    public HelperDB( Context context) {
        super(context,DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_PERSONALINFO;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+STUDENT_ID+" TEXT,";
        strCreate+=" "+ STUDENT_CLASS+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_GRADES;
        strCreate+=" ("+grades.KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+MATH+" INTEGER,";
        strCreate+=" "+ENGLISH+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete = "DROP TABLE IF EXISTS " + TABLE_PERSONALINFO;
        db.execSQL(strDelete);
        strDelete = "DROP TABLE IF EXISTS " + TABLE_GRADES;
        db.execSQL(strDelete);
        onCreate(db);
    }
}
