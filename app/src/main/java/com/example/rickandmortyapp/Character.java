package com.example.rickandmortyapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class Character implements Modelo {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String origin;
    private String originURL;
    private String location;
    private String locationURL;
    private String image;
    private ArrayList<String> episodesURL;
    private String ownURL;
    private String created;

    @Override
    public void JsonToModel(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getInt("id");
        name = jsonObject.getString("name");
        status = jsonObject.getString("status");
        species = jsonObject.getString("species");
        type = jsonObject.getString("type");
        gender = jsonObject.getString("gender");
        origin = jsonObject.getJSONObject("origin").getString("name");
        originURL = jsonObject.getJSONObject("origin").getString("url");
        location = jsonObject.getJSONObject("location").getString("name");
        image = jsonObject.getString("image");
        episodesURL = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("episode");
        for( int i = 0; i <jsonArray.length(); ++i) {
            episodesURL.add(jsonArray.getString(i));
        }
        ownURL = jsonObject.getString("url");
        created = jsonObject.getString("created");
        Log.d("ARRAY", name);

    }
}
