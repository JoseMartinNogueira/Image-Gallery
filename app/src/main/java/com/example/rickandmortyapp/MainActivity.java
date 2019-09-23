package com.example.rickandmortyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String baseURL =  "https://rickandmortyapi.com/api/";
    private String compURL;

    private RequestQueue requestQueue;
    private ArrayList<Modelo> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String url ="https://rickandmortyapi.com/api/";

        TextView textView = (TextView) findViewById(R.id.textView);

        compURL = "character";
        modelList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        retrieveJson();

        modelList.size();

    }

    public void retrieveJson() {

        String url = baseURL.concat("character");
        JsonObjectRequest jsonObjectReq = new JsonObjectRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray jsonArray = response.getJSONArray("results");
                            //Log.d("ARRAY", "RETRIEVE");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Modelo model = ModelFactory.getModel(compURL);
                                model.JsonToModel(jsonObject);
                                modelList.add(model);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonObjectReq);
    }
}
