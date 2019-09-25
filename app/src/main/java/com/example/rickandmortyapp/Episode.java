package com.example.rickandmortyapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Episode implements Modelo {

    private int id;
    private String name;
    private String airDate;
    private String episode;
    private ArrayList<String> characters;
    private String url;
    private String created;

    @Override
    public void JsonToModel(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getInt("id");
        name = jsonObject.getString("name");
        airDate = jsonObject.getString("air_date");
        episode = jsonObject.getString("episode");
        characters = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("characters");
        for (int i = 0; i < jsonArray.length(); ++i) {
            characters.add(jsonArray.getString(i));
        }
        url = jsonObject.getString("url");
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
}
