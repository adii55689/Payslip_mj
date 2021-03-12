package com.example.payslip;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    EditText etname,etmobile,etemail,etaddress,etjob,etgender,etjoining;
    Button btaddEmployee;

    private int REQUEST_PDF  = 21;
    private String encoded_pdf;


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

        Button uploadCsvButton = findViewById(R.id.uploadCsv);
        uploadCsvButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.addCategory(Intent.CATEGORY_OPENABLE);
                chooseFile.setType("text/*");
                chooseFile = Intent.createChooser(chooseFile, "Choose CSV file.");
                startActivityForResult(chooseFile,REQUEST_PDF);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode!=REQUEST_PDF || data == null || resultCode != RESULT_OK ) return;
        Log.d("dbg", "onActivityResult: "+ requestCode + data + resultCode);
        Uri path = data.getData();

        Log.d("dbg", "onActivityResult: "+ path);

        try {
            InputStream inputStream = MainActivity.this.getContentResolver().openInputStream(path);

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, Charset.forName("UTF-8"))
            );

            String line = "";
            int lineNo = 0;

            try{
                while ((line = bufferedReader.readLine()) != null){
                    if(lineNo++ == 0) continue;
                    Log.d("CSV_DATA", line);
                    String[] tokens = line.split(",");

                }
            }
            catch (IOException e){
                e.printStackTrace();
            }

//            byte[] csvInBytes = new byte[inputStream.available()];

//            inputStream.read(csvInBytes);
//
//            encoded_pdf = Base64.encodeToString(csvInBytes, Base64.DEFAULT);
//
//            Log.d("dbg", "onActivityResult: "+ encoded_pdf);
//
//            Toast.makeText(MainActivity.this, encoded_pdf, Toast.LENGTH_LONG);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}