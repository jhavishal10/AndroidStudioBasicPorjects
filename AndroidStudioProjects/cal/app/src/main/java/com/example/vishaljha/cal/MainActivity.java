package com.example.vishaljha.cal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b0,b1,b2,badd,bsub,bans;
    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tvs);
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        badd=findViewById(R.id.badd);
        bsub=findViewById(R.id.bsub);
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        badd.setOnClickListener(this);
        bsub.setOnClickListener(this);
        bans=findViewById(R.id.bans);
        bans.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.b0:{
                textView.setText(textView.getText()+"0");
                break;
            }
            case R.id.badd:{
                textView.setText(textView.getText()+"+");
                break;
            }
            case R.id.bsub:{
                textView.setText(textView.getText()+"-");
                break;
            }
            case R.id.b1:{
                textView.setText(textView.getText()+"1");
                break;
            }
            case R.id.bans:{
                int a=(ans(textView.getText().toString()));
                textView.setText(String.valueOf(a));
                break;
            }
        }

    }
    public int ans(String str){
        Stack<String> stack=new Stack<>();
        stack.push((textView.getText()).toString());
        return 001;
    }
}
