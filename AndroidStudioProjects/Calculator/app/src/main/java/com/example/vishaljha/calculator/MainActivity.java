package com.example.vishaljha.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;

    TextView textView;
    TextView textView1;
    int i = 0;
    String str = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txtInput);
        textView1 = findViewById(R.id.txtSolution);
        button0 =  findViewById(R.id.btn0);
        button1 =  findViewById(R.id.btn1);
        button2 =  findViewById(R.id.btn2);
        button3 =  findViewById(R.id.btn3);
        button4 =  findViewById(R.id.btn4);
        button5 =  findViewById(R.id.btn5);
        button6 =  findViewById(R.id.btn6);
        button7 =  findViewById(R.id.btn7);
        button8 =  findViewById(R.id.btn8);
        button9 =  findViewById(R.id.btn9);
        buttonDivision = findViewById(R.id.btnDivide);
        buttonAdd =  findViewById(R.id.btnAdd);
        buttonMul =  findViewById(R.id.btnMultiply);
        buttonSub =  findViewById(R.id.btnSubtract);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        button10.setOnClickListener(this);
        buttonC.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0: {
                textView.setText(textView.getText() + "0");
                str = textView.getText().toString();
                i = Integer.parseInt(str);
                break;
            }
            case R.id.btn1: {

                textView.setText(textView.getText() + "1");
                break;
            }
            case R.id.btnAdd: {

                textView.setText("+");
                textView1.setText(i);
                break;
            }

        }
    }
}


