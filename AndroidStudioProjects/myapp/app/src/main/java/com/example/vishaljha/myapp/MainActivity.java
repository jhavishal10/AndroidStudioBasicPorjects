package com.example.vishaljha.myapp;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class    MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("Study Zone Tutions");
        ab.setMessage("hey yash ,how are you!!!!!");
        ab.setIcon(R.drawable.rachit1);
        ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "yash to paagal hai", Toast.LENGTH_LONG).show();
            }
        });



        ab.setNegativeButton("no", null);
        ab.setNeutralButton("cancel", null);

        ab.show();
    }

       //  b1=findViewById(R.id.bu

    public void fun(View v){
        if(v.getId()==R.id.button1) {
            Toast.makeText(this, "button 1 clicked", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.button2){
           // Toast.makeText(this, "button 2 clicked", Toast.LENGTH_SHORT).show();
            Toast t =new Toast(this);
            t.setDuration(Toast.LENGTH_LONG);
            //LayoutInflater l= getLayoutInflater();
            View vw=getLayoutInflater().inflate(R.layout.imagesourcefile,null);
            t.setView(vw);
            t.show();
        }
        else if(v.getId()==R.id.button3){
           // Toast.makeText(this, "button 3 clicked", Toast.LENGTH_SHORT).show();
            Toast m=new Toast(this);
            m.setDuration(Toast.LENGTH_LONG);
            View n=getLayoutInflater().inflate(R.layout.edittextresourcefile,null);
            m.setView(n);
            m.show();
        }
//        String []name=("Raj","Rohan","Riya");
//        ArrayAdapter adp=new ArrayAdapter(this,android.R.layout.simple_list_item_1)
//
//                Spinner s=findViewById(R.id.)
//                        s.setAdapter(adp);
//        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, i+"clicked", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
}

}
