package com.example.payslip;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLists extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_lists);
        ActionBar actionBar;
        actionBar =getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2b6bb3")));
        ArrayList<Employee> employees = (ArrayList<Employee>)getIntent().getSerializableExtra("employeesList");

        ListView listView = findViewById(R.id.employeesList);

        List empNames = new ArrayList();

        for(Employee employee: employees){
            empNames.add(employee.getEmpName());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (EmployeeLists.this, android.R.layout.simple_list_item_1,empNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    DrawImage drawImage = new DrawImage();
                    Employee employee = employees.get(position);
                    int y = 100;
                    int startX = 20;
                    int startX2 = startX + 550;
                    int defaultTextSize = 25;

                    drawImage.drawText("PAY SLIP",300,y, 100);

                    y+=90;

                    drawImage.drawText("Employee Name:    "+employee.getEmpName(),startX,y, defaultTextSize);
                    drawImage.drawText("PF No:    "+employee.getPfNo(),startX2,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("Work Days:    "+employee.getPresentDays(),startX,y, defaultTextSize);
                    drawImage.drawText("UAN No:    "+employee.getUanNo(),startX2,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("Arrear Days:    "+employee.getArrearDays(),startX,y, defaultTextSize);
                    drawImage.drawText("ESIC No:    "+employee.getEsicNo(),startX2,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("Adhaar No:    "+employee.getAdhaarNumber(),startX,y, defaultTextSize);

                    y+=80;

                    drawImage.drawText("Earnings:    "+employee.getAdhaarNumber(),startX,y, defaultTextSize);
                    drawImage.drawText("Deductions:    "+employee.getAdhaarNumber(),startX2,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("BASIC + DA + Arrear:    "+employee.getPfWages(),startX,y, defaultTextSize);
                    drawImage.drawText("PF:    "+employee.getEPF(),startX2,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("HRA:    "+employee.getHRA(),startX,y, defaultTextSize);
                    drawImage.drawText("ESIC:    "+employee.getESI(),startX2,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("PT:    "+employee.getPT(),startX,y, defaultTextSize);
                    drawImage.drawText("Overtime:    "+employee.getOvertimeAmount(),startX2,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("Other Allowances:    "+employee.getOtherAllowance(),startX,y, defaultTextSize);

                    y+=60;

                    drawImage.drawText("Total Earnings:    "+employee.getTotalWagesPayable(),startX,y, defaultTextSize);
                    drawImage.drawText("Total Deduction:    "+employee.getTotalDeduction(),startX2,y, defaultTextSize);

                    y+=80;

                    drawImage.drawText("Net Pay:    "+employee.getNetPaid(),startX,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("Bank Name:    "+employee.getBankName(),startX,y, defaultTextSize);
                    drawImage.drawText("Payment Method:    Fund Transfer",startX2,y, defaultTextSize);

                    y+=40;

                    drawImage.drawText("Account Number:    "+employee.getAccNo(),startX,y, defaultTextSize);
                    drawImage.drawText("Paid Date:    "+employee.getPaidDate(),startX2,y, defaultTextSize);



//                    drawImage.drawText("EMP Code: "+employees.get(position).getEm(),2,40, 20);
                    shareFile(drawImage.exportImage(getApplicationInfo().dataDir +"/Bill.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    void shareFile(String filePath){
        Intent intentShareFile = new Intent(Intent.ACTION_SEND);
        File fileWithinMyDir = new File(filePath);

        if(fileWithinMyDir.exists()) {
            intentShareFile.setType("image/png");
            intentShareFile.putExtra(Intent.EXTRA_STREAM, FileProvider.
                    getUriForFile(this,
                            BuildConfig.APPLICATION_ID+".provider",
                            fileWithinMyDir));

            intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                    "Sharing File...");
            intentShareFile.putExtra(Intent.EXTRA_TEXT, "Your Bill...");

            startActivity(Intent.createChooser(intentShareFile, "Share File"));
        }
    }



    String createImage(final String text) throws IOException {

            return new DrawImage()
                    .drawText(text,0,40, 30)
                    .exportImage(getApplicationInfo().dataDir +"/Bill.png");

    }
}