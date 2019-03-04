package com.abhiwan.gramoday.gramodaysankalp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    EditText email,feed;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        submit=(Button) findViewById(R.id.submit);
        email=(EditText) findViewById(R.id.email);
        feed=(EditText) findViewById(R.id.feed);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code=email.getText().toString().trim();
                if(code.length()<10 ){
                    email.setError("Not a valid Email");
                    email.requestFocus();
                    return ;
                }String code2=feed.getText().toString().trim();
                if(code2.length()<20 ){
                    feed.setError("Give feedback");
                    feed.requestFocus();
                    return ;
                }
                if(code.length()<10 && code2.length()<20 ){
                    email.setError("Not a valid Email");
                    email.requestFocus();
                    feed.setError("Give feedback");
                    feed.requestFocus();
                    return ;
                }
                if(!code.isEmpty()&& !code2.isEmpty()){
                    Toast.makeText(Feedback.this, "Feedback submitted successfully",
                            Toast.LENGTH_LONG).show();
                    email.setText("");
                    feed.setText("");
                }

            }
        });
    }
}
