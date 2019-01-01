package com.example.user.yamdb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    HelperDB hlp;
    String strID , strClass, strName, strEnglish, strMath;
    EditText etID, etClass, etName, etEnglish, etMath;
    Intent t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();

        etID = (EditText) findViewById(R.id.etID);
        etClass = (EditText) findViewById(R.id.etClass);
        etName = (EditText) findViewById(R.id.etName);
        etEnglish = (EditText) findViewById(R.id.etEnglish);
        etMath = (EditText) findViewById(R.id.etMath);

    }

    public void sndData1(View view) {
        strID = etID.getText().toString();
        strClass= etClass.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(personalInfo.STUDENT_ID, strID);
        cv.put(personalInfo.STUDENT_CLASS, strClass);
        db = hlp.getWritableDatabase();
        db.insert(personalInfo.TABLE_PERSONALINFO,null, cv);
        db.close();
    }

    public void sndData2(View view) {
        ContentValues cv = new ContentValues();
        strName= etName.getText().toString();
        strEnglish= etEnglish.getText().toString();
        strMath= etMath.getText().toString();
        cv.put(grades.NAME, strName);
        cv.put(grades.ENGLISH, strEnglish);
        cv.put(grades.MATH, strMath);
        db = hlp.getWritableDatabase();
        db.insert(grades.TABLE_GRADES,null, cv);
        db.close();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if (st.equals("tables")){
            t = new Intent(this, Main2Activity.class);
            startActivity(t);
        }
        if (st.equals("credits"))
            Toast.makeText(this, "this app was created by Yam, thanks for ALBERT", Toast.LENGTH_LONG).show();
            return super.onOptionsItemSelected(item);
    }
}
