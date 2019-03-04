package com.abhiwan.gramoday.gramodaysankalp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;


import java.util.concurrent.TimeUnit;


public class OtpVerification extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public String phoneNumber,Name,BloodGroup;
    private String verificationID;
    Button buttonSignIn;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        phoneNumber=extras.getString("phoneNumber");
        Name=extras.getString("name");
        BloodGroup=extras.getString("bloodgroup");
        mAuth=FirebaseAuth.getInstance();
        sendVerificationCode(phoneNumber);
        buttonSignIn=findViewById(R.id.buttonSignIn);
        editText=findViewById(R.id.editText);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code=editText.getText().toString().trim();
                if(code.isEmpty()||code.length()<6 ){
                    editText.setError("Enter Code.....");
                    editText.requestFocus();
                    return ;
                }
                verifycode(code);
            }
        });
    }
    private void verifycode(String code){
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationID, code);
        signInWithCredential(credential);
    }
    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    SignUp r=new SignUp();
                    r.addRequest(phoneNumber,Name);
                    Intent i =new Intent(OtpVerification.this,Login.class);
                    getIntent().setFlags(i.FLAG_ACTIVITY_NEW_TASK|i.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }else{

                    Toast.makeText(OtpVerification.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void sendVerificationCode(String number){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                120,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationID=s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code=phoneAuthCredential.getSmsCode();
            if(code !=null){
                verifycode(code);
            }
        }
        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(OtpVerification.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    };
    public void onBackPressed() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Exit")
                .setMessage("Do you Really want to exit ?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }

}
