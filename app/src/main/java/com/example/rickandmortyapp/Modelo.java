package com.example.rickandmortyapp;

import org.json.JSONException;
import org.json.JSONObject;

public interface Modelo {

    public void JsonToModel(JSONObject jsonObject) throws JSONException;

    public String getImageURL();

    public String getName();

    public String getStatus();

    public String getSpecies();

    public String getType();

    public String getGender();

}
