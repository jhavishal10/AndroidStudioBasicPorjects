package com.studyzone.vishaljha.bloodbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Login extends AppCompatActivity {
    Spinner spinnerBloodGroup ;
    Spinner PinCodes;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //age setting

        //bloodgroup spinner setting
        spinnerBloodGroup= (Spinner) findViewById(R.id.spinnerBloodGroup);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.BloodGroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBloodGroup.setAdapter(adapter);

        //pincodespinner setting
        PinCodes= (Spinner) findViewById(R.id.PinCodes);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.pincodes, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PinCodes.setAdapter(adapter2);
    }
}
