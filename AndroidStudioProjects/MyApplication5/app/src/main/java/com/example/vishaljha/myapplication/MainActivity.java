package com.example.vishaljha.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder ab=new AlertDialog.Builder( this);
        ab.setIcon(R.drawable.ic_launcher_background);
        ab.setTitle("My dialogue");
        ab.setMessage("hello rupam whatsupp");
        ab.setPositiveButton("yes",null);
        ab.setNegativeButton("NO",null);
        ab.setNeutralButton("cancel", null);
        ab.show();
//        int yy=0,mm=0,dd=0;
//        Calendar c =Calendar.getInstance();
//        yy=c.YEAR;
//        mm=c.MONTH;
//        dd=c.DAY_OF_MONTH;
//
//
//            DatePickerDialog dp=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//                @Override
//                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//
//                }
//            }

    }

}
