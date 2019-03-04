package com.example.vishaljha.cal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AlertDialog.Builder a=new AlertDialog.Builder(this);
        a.setIcon(R.drawable.ic_launcher_background);
        a.setTitle("This is a beta version do u really want to continue");
        a.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        a.setNegativeButton("no",null);
        a.show();
    }
}
