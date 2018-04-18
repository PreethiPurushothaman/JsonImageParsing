package com.example.hp.onlineflag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String url = "http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject;
                        JSONArray jsonArray;
                        try
                        {
                            jsonObject= new JSONObject(response);
                            jsonArray=jsonObject.getJSONArray("worldpopulation");

                            for (int i = 0; i <jsonArray.length() ; i++)
                            {
                                JSONObject countries=(JSONObject)jsonArray.get(i);

                                String country=countries.getString("country");
                                String popu=countries.getString("population");
                                String rank=countries.getString("rank");
                                String pic = countries.getString("flag");
                                ModelClass listModel = new ModelClass(rank,country,popu,pic);
                                arrayList.add(listModel);
                            }
                            adapter = new MyAdapter(MainActivity.this,arrayList);
                            recyclerView.setAdapter(adapter);

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error is"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){


        };

        queue.add(stringRequest);

    }
}
