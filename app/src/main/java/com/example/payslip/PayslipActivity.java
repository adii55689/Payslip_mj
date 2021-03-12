package com.example.payslip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class PayslipActivity extends AppCompatActivity {
    List listElementsArrayList = new ArrayList<String>();;
    OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payslip);

        SearchView searchView;
        ListView listView;

        listView = findViewById(R.id.employeeListView);

        searchView = findViewById(R.id.searchView);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (PayslipActivity.this, android.R.layout.simple_list_item_1, listElementsArrayList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nameClicked = listView.getItemAtPosition(i).toString();
                searchView.setQuery(nameClicked, true);
                searchView.clearFocus();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                try {
                    List<String> resp = get(newText);
                    listElementsArrayList.clear();
                    if(resp.size()==0){
                        listView.setVisibility(View.INVISIBLE);
                        return false;
                    }
                    for(int i =0; i<resp.size();i++){
                        System.out.println(resp.get(i));
                        listElementsArrayList.add(resp.get(i));
                    }
                    listView.setVisibility(View.VISIBLE);
                    adapter.notifyDataSetChanged();


//                    Toast.makeText(getApplicationContext(),
//                            resp, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });
    }

    List<String> get(String name) throws IOException {
//        RequestBody body = RequestBody.create(json, JSON);
        String url = "https://payslipmj.tk/api/employees/search";
        if(!name.isEmpty()){
            url+="?name="+name;
        }
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return Arrays.asList(response.body().string().split(","));
        }
    }


}