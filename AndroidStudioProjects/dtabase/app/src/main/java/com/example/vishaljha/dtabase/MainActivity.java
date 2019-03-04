package com.example.vishaljha.dtabase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
//    public void fun(View v){
//        SharedPreferences sp=getSharedPreferences("mysp",MODE_PRIVATE);
//        SharedPreferences.Editor e=sp.edit();
//        e.putString("name",".........vishal.........");
//        e.commit();
//        Intent i=new Intent(MainActivity.this,Main2Activity.class);
//        startActivity(i);
//    }
}
