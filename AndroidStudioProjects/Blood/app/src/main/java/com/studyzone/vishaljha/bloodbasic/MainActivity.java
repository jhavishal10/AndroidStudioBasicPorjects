package com.studyzone.vishaljha.bloodbasic;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button CreateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Chart=(Button)findViewById(R.id.Chart);
        Button Donation=(Button)findViewById(R.id.Donation);
        Button Request=(Button)findViewById(R.id.Request);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView expandedTitle = (TextView) findViewById(R.id.titleCollapsing);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle("Main");
        expandedTitle.setText("Main");

        Request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(MainActivity.this,RequestActivity.class);
                startActivity(in);
            }
        });
        Chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,BloodChart.class);
                startActivity(i);
            }
        });
        Donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Donation.class);
                startActivity(i);
            }
        });
        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.BloodGroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1: {
                        Intent intent = new Intent(MainActivity.this, Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent = new Intent(MainActivity.this, Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent = new Intent(MainActivity.this, Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        Intent intent = new Intent(MainActivity.this, Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 5: {
                        Intent intent = new Intent(MainActivity.this, Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 6: {
                        Intent intent = new Intent(MainActivity.this, Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 7: {
                        Intent intent = new Intent(MainActivity.this, Donation.class);
                        startActivity(intent);
                        break;
                    }
                    case 8: {
                        Intent intent = new Intent(MainActivity.this, Donation.class);
                        startActivity(intent);
                        break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
