package com.example.vishaljha.dtabase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        SharedPreferences sp=getSharedPreferences("mysp",MODE_PRIVATE);
//        String s=sp.getString("name","null");
//        TextView textView=findViewById(R.id.tv);
//        textView.setText(s);

        Thread t=new Thread(){
            public void run(){
                try{
                    Thread.sleep(1000);
                    Intent i =new Intent(Main2Activity.this,MainActivity.class);
                    startActivity(i);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t.start();


    }
}
