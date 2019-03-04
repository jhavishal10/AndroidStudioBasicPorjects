package com.studyzone.vishaljha.bloodbasic;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RequestActivity extends AppCompatActivity {
    //creating References
    Button RequestButton ;
   public EditText editTextMobile;
   public EditText editTextName ;
   public Spinner spinnerBloodGroup ;
    DatabaseReference fdbRefer;
   public String MobileNumber,Name,BloodGroup,PhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView expandedTitle = (TextView) findViewById(R.id.titleCollapsing);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle("Request");
        expandedTitle.setText("Request");

        //assigning of objects


        editTextName= (EditText) findViewById(R.id.editTextName);
        RequestButton= (Button) findViewById(R.id.Request);
      //  editTextName= (EditText) findViewById(R.id.editTextName);
        editTextMobile=(EditText) findViewById(R.id.editTextMobile);
        spinnerBloodGroup= (Spinner) findViewById(R.id.spinnerBloodGroup);
        //setting up spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.BloodGroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBloodGroup.setAdapter(adapter);

        RequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MobileNumber=editTextMobile.getText().toString().trim();
                //addRequest();
               checkMobileExists(MobileNumber);
            }
        });

    }
       public void checkMobileExists(String s){
           BloodGroup = spinnerBloodGroup.getSelectedItem().toString();
           Name = editTextName.getText().toString().trim();

           fdbRefer = FirebaseDatabase.getInstance().getReference().child("Donors");
           fdbRefer.orderByChild("requestId").equalTo("+91"+s).addListenerForSingleValueEvent(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   if(Name.isEmpty()){
                       Toast.makeText(RequestActivity.this,"Enter Name",Toast.LENGTH_SHORT).show();
                   }else if(Name.length()<3||Name.length()>=24){
                       Toast.makeText(RequestActivity.this,"Not a Valid name",Toast.LENGTH_SHORT).show();
                   }else if(BloodGroup.equals("Select Blood Group")){
                       Toast.makeText(RequestActivity.this,"Select Blood Group",Toast.LENGTH_SHORT).show();
                   }else if(MobileNumber.isEmpty()){
                       Toast.makeText(RequestActivity.this,"Enter Phone number",Toast.LENGTH_SHORT).show();
                   }else if(MobileNumber.length()<10){
                        Toast.makeText(RequestActivity.this," Not a Valid Number",Toast.LENGTH_SHORT).show();
                   }else if(dataSnapshot.exists()){
                        Toast.makeText(RequestActivity.this," this Number Already Exists",Toast.LENGTH_SHORT).show();
                   }else{
                        //first verify OTP then add request
                        Intent i =new Intent(RequestActivity.this,OtpVerification.class);
                        Bundle extras=new Bundle();
                        MobileNumber=editTextMobile.getText().toString().trim();
                        PhoneNumber="+91"+MobileNumber;
                        extras.putString("phoneNumber",PhoneNumber);
                        extras.putString("name",Name);
                        extras.putString("bloodgroup",BloodGroup);
                        i.putExtras(extras);
                        startActivity(i);
                    }
               }
               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {

               }
           });
       }

    //adding the request for donation to the database
    public void addRequest(String PhoneNumber,String Name,String BloodGroup){

        //MobileNumber=editTextMobile.getText().toString().trim();
       // PhoneNumber="+91"+MobileNumber;

        //if((!TextUtils.isEmpty(Name)&&!BloodGroup.equals("Select Blood Group"))&&(!TextUtils.isEmpty(MobileNumber)&&MobileNumber.length()==10))
        {
            //String id=db.push().getKey();
            DatabaseReference db;
            db=FirebaseDatabase.getInstance().getReference("Donors");
            Request request=new Request(PhoneNumber,Name,BloodGroup);
            db.child(PhoneNumber).setValue(request);


        }//else{
           // Toast.makeText(this, "Fill all Values", Toast.LENGTH_SHORT).show();//for invalid names
        //}
    }
    }

