package com.studyzone.vishaljha.bloodbasic;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


public class BloodChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_chart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView expandedTitle = (TextView) findViewById(R.id.titleCollapsing);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle("Blood Chart");
        expandedTitle.setText("Blood Chart");
    }
}
