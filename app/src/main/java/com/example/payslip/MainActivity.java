package com.example.payslip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        setContentView(R.layout.home_page);


        Button employeePageButton = findViewById(R.id.Employee_add);
        employeePageButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, EmployeeActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        }));

        Button paymentButton = findViewById(R.id.payment_payslip);
        paymentButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PayslipActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        }));


        /*final Button pay = findViewById(R.id.pay_final);
        pay.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Pay Now Button is clicked", Toast.LENGTH_LONG).show();
            }
        }));*/



//        etname = findViewById(R.id.et_name);
//        etmobile= findViewById(R.id.et_mobile);
//        etemail = findViewById(R.id.et_mail);
//        etaddress= findViewById(R.id.et_address);
//        etjob =findViewById(R.id.et_job);
//        etgender=findViewById(R.id.et_gender);
//        etjoining=findViewById(R.id.et_join_date);
//        btaddEmployee=findViewById(R.id.add_employee);




    }
}