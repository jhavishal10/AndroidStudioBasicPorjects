package com.studyzone.vishaljha.delete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference fdbRefer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fdbRefer= FirebaseDatabase.getInstance().getReference("hello");
        String id=  fdbRefer.push().getKey();
    }
}