package com.example.rickandmortyapp;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RetrieveData  {

    private ArrayList<Modelo> modelList;
    private static String baseURL =  "https://rickandmortyapi.com/api/";
    private String compURL;
    private String url;

    public RetrieveData(String compURL ) {
        url = baseURL.concat(compURL);
        this.compURL = compURL;
    }

    public ArrayList<Modelo> getModels() {
        return modelList;
    }

    public void retrieveJson() {
        JsonObjectRequest jsonObjectReq = new JsonObjectRequest(Request.Method.GET, url, null,

        new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("results");

                    

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
    }

}
