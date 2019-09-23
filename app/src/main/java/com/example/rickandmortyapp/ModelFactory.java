package com.example.rickandmortyapp;

public class ModelFactory {

    public static Modelo getModel(String type)
    {
        if( type.equals("character")) {
            return new Character();
        }
        else if( type.equals("location") ) {
            return  new Location();
        }
        else if( type.equals("episode") ) {
            return  new Episode();
        }
        return null;
    }

}
