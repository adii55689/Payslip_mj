package com.example.payslip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etname,etmobile,etemail,etaddress,etjob,etgender,etjoining;
    Button btaddEmployee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button add_E = findViewById(R.id.add_employee);
        add_E.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Add_Employee Button Clicked", Toast.LENGTH_LONG).show();
            }
        }));


        final Button pay = findViewById(R.id.pay_final);
        add_E.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Pay Now Button is clicked", Toast.LENGTH_LONG).show();
            }
        }));



        etname = findViewById(R.id.et_name);
        etmobile= findViewById(R.id.et_mobile);
        etemail = findViewById(R.id.et_mail);
        etaddress= findViewById(R.id.et_address);
        etjob =findViewById(R.id.et_job);
        etgender=findViewById(R.id.et_gender);
        etjoining=findViewById(R.id.et_join_date);
        btaddEmployee=findViewById(R.id.add_employee);




    }
}