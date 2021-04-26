package com.example.payslip;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etname,etmobile,etemail,etaddress,etjob,etgender,etjoining;
    Button btaddEmployee;

    private int REQUEST_PDF  = 21;
    private String encoded_pdf;

    private static final int PERMISSION_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        if (Build.VERSION.SDK_INT >= 23)
        {
            if (checkPermission())
            {
                // Code for above or equal 23 API Oriented Device
                // Your Permission granted already .Do next code
            } else {
                requestPermission(); // Code for permission
            }
        }




        TextView employeePageButton = findViewById(R.id.Employee_add);
        employeePageButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, EmployeeActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        }));

        TextView paymentButton = findViewById(R.id.payment_payslip);
        paymentButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PayslipActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        }));

        TextView uploadCsvButton = findViewById(R.id.uploadCsv);
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

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(MainActivity.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
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

            CsvFile csvFile = new CsvFile(inputStream);
            ArrayList<String[]> list = (ArrayList<String[]>) csvFile.read();

            ArrayList<Employee> employees = new ArrayList<>();
            int cnt = 0;
            for(String[] scoreData: list ) {
                if(cnt++ == 0) continue;
                Employee employee = new Employee();
                employee.setPfNo(scoreData[0]);
                employee.setEsicNo(scoreData[1]);
                employee.setUanNo(scoreData[2]);
                employee.setEmpName(scoreData[3]);
                employee.setAdhaarNumber(scoreData[4]);
                employee.setBankName(scoreData[5]);
                employee.setAccNo(scoreData[6]);
                employee.setIfscCode(scoreData[7]);
                employee.setGrade(scoreData[8]);
                employee.setPresentDays(scoreData[9]);
                employee.setArrearDays(scoreData[10]);
                employee.setUnitOfWorkDone(scoreData[11]);
                employee.setRateOfMinWages(scoreData[12]);
                employee.setBASIC(scoreData[13]);
                employee.setDA(scoreData[14]);
                employee.setOtherAllowance(scoreData[15]);
                employee.setBasicEarning(scoreData[16]);
                employee.setDaEarning(scoreData[17]);
                employee.setArrearEarning(scoreData[18]);
                employee.setOtherAllwEarning(scoreData[19]);
                employee.setPfWages(scoreData[20]);
                employee.setOvertimeAmount(scoreData[21]);
                employee.setHRA(scoreData[22]);
                employee.setTotalWagesPayable(scoreData[23]);
                employee.setEPF(scoreData[24]);
                employee.setPT(scoreData[25]);
                employee.setESI(scoreData[26]);
                employee.setTotalDeduction(scoreData[27]);
                employee.setNetPaid(scoreData[28]);
                employee.setPaidDate(scoreData[29]);
                employees.add(employee);
            }

            Intent myIntent = new Intent(MainActivity.this, EmployeeLists.class);
            myIntent.putParcelableArrayListExtra("employeesList", employees);
            MainActivity.this.startActivity(myIntent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}