package com.example.rickandmortyapp;

import org.json.JSONException;
import org.json.JSONObject;

public interface Modelo {

    public void JsonToModel(JSONObject jsonObject) throws JSONException;

}
