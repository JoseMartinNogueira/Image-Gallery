package com.example.rickandmortyapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Location implements Modelo {

    private int id;
    private String name;
    private String type;
    private String dimension;
    private ArrayList<String> residents;
    private String ownURL;
    private String created;

    @Override
    public void JsonToModel(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getInt("id");
        name = jsonObject.getString("name");
        type = jsonObject.getString("type");
        dimension = jsonObject.getString("dimension");
        residents = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("residents");
        for( int i = 0; i <jsonArray.length(); ++i) {
            residents.add(jsonArray.getString(i));
        }
        ownURL = jsonObject.getString("url");
        created = jsonObject.getString("created");
    }

    @Override
    public String getImageURL() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public String getSpecies() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getGender() {
        return null;
    }
}
