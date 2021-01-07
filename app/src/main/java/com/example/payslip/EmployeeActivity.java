package com.example.payslip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EmployeeActivity extends AppCompatActivity {

    EditText etname,etmobile,etemail,etaddress,etjob,etgender,etjoining;
    Button btaddEmployee;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        etname = findViewById(R.id.et_name);
        etmobile= findViewById(R.id.et_mobile);
        etemail = findViewById(R.id.et_mail);
        etaddress= findViewById(R.id.et_address);
        etjob =findViewById(R.id.et_job);
        etgender=findViewById(R.id.et_gender);
        etjoining=findViewById(R.id.et_join_date);
        btaddEmployee=findViewById(R.id.add_employee);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        JSONObject empRequest = new JSONObject();




        btaddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    try {
                        empRequest.put("name",etname.getText().toString());
                        empRequest.put("phone","+91"+etmobile.getText().toString());
                        empRequest.put("email",etemail.getText().toString());
                        empRequest.put("address",etaddress.getText().toString());
                        empRequest.put("job",etjob.getText().toString());
                        empRequest.put("gender",etgender.getText().toString());
                        empRequest.put("joining",etjoining.getText().toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    submitData(empRequest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    String submitData(JSONObject empDetails) throws IOException {

        String response = post("https://payslipmj.tk/api/employees/",empDetails.toString());
        Toast.makeText(getApplicationContext(),
                response, Toast.LENGTH_LONG).show();
        return response;
    }

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}