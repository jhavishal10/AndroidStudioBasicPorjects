package com.abhiwan.gramoday.gramodaysankalp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    public EditText editTextMobile;
    public EditText editTextName ;
    Button RequestButton ;
    DatabaseReference fdbRefer;
    public String MobileNumber,Name,PhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fdbRefer = FirebaseDatabase.getInstance().getReference().child("Hello");
        editTextName= (EditText) findViewById(R.id.editTextName);
        RequestButton= (Button) findViewById(R.id.submit);
        editTextMobile=(EditText) findViewById(R.id.editTextMobile);
        RequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MobileNumber=editTextMobile.getText().toString().trim();
                //addRequest();
                Name = editTextName.getText().toString().trim();

                checkMobileExists(MobileNumber);
            }
        });
    }
    public void checkMobileExists(String s){
//        Toast.makeText(SignUp.this,"Hello",Toast.LENGTH_SHORT).show();

        Name = editTextName.getText().toString().trim();

        fdbRefer = FirebaseDatabase.getInstance().getReference().child("Donors");
        fdbRefer.orderByChild("requestId").equalTo("+91"+s).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(Name.isEmpty()){
                    Toast.makeText(SignUp.this,"Enter Name",Toast.LENGTH_SHORT).show();
                }else if(Name.length()<3||Name.length()>=24){
                    Toast.makeText(SignUp.this,"Not a Valid name",Toast.LENGTH_SHORT).show();
                }else if(MobileNumber.isEmpty()){
                    Toast.makeText(SignUp.this,"Enter Phone number",Toast.LENGTH_SHORT).show();
                }else if(MobileNumber.length()<10){
                    Toast.makeText(SignUp.this," Not a Valid Number",Toast.LENGTH_SHORT).show();
                }
                //else if(dataSnapshot.exists()){
                   // Toast.makeText(SignUp.this," this Number Already Exists",Toast.LENGTH_SHORT).show();
                //}
                else{
                    //first verify OTP then add request
                    Intent i =new Intent(SignUp.this,OtpVerification.class);
                    Bundle extras=new Bundle();
                    MobileNumber=editTextMobile.getText().toString().trim();
                    PhoneNumber="+91"+MobileNumber;
                    extras.putString("phoneNumber",PhoneNumber);
                    extras.putString("name",Name);
                    i.putExtras(extras);
                    startActivity(i);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void addRequest(String PhoneNumber,String Name){

        {
            DatabaseReference db;
            db=FirebaseDatabase.getInstance().getReference("Donors");
            Request request=new Request(PhoneNumber,Name);
            db.child(PhoneNumber).setValue(request);
        }
    }
    public void onBackPressed() {
        moveTaskToBack(true);

    }
}
