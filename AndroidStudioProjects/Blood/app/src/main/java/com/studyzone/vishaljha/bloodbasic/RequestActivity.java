package com.studyzone.vishaljha.bloodbasic;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestActivity extends AppCompatActivity {
    //creating Refernces
    Button RequestButton ;
    EditText editTextName ;
    Spinner spinnerBloodGroup ;
    DatabaseReference databaseRequests;

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
        databaseRequests=FirebaseDatabase.getInstance().getReference("Donors");
        RequestButton= (Button) findViewById(R.id.Request);
        editTextName= (EditText) findViewById(R.id.editTextName);
        spinnerBloodGroup= (Spinner) findViewById(R.id.spinnerBloodGroup);

        //setting up spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.BloodGroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBloodGroup.setAdapter(adapter);
        RequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addRequest();
            }
        });
    }
    //adding the request for donation to the database
        private void addRequest(){
            String Name = editTextName.getText().toString().trim();
            String BloodGroup = spinnerBloodGroup.getSelectedItem().toString();
            if (!TextUtils.isEmpty(Name)&&!BloodGroup.equals("Select Blood Group")) {
                String id=databaseRequests.push().getKey();
                Request request=new Request(id,Name,BloodGroup);
                databaseRequests.child(id).setValue(request);
                Toast.makeText(this,"Request added successfully",Toast.LENGTH_SHORT).show();//crosscheck of adding to the database
            } else
                {
                Toast.makeText(this, "Please Enter Values", Toast.LENGTH_SHORT).show();//for invalid names
            }
       }

    }

