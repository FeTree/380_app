package com.example.inventorymanager.model;

import java.util.ArrayList;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SerializeData
{
    Gson gson = new Gson();
    // Type profileListType = new TypeToken<ArrayList<Profile>>(){}.getType();
    // Type locationListType = new TypeToken<ArrayList<Location>>(){}.getType();
    Type itemListType = new TypeToken<ArrayList<Item>>(){}.getType();
    Type LocationType = new TypeToken<Location>(){}.getType();

    public String[] serializeLocation(Location location) {
        String locationJSONStr, itemsJSONstr;
        locationJSONStr = gson.toJson(location)
        itemsJSONstr = gson.toJson(location.Items);
        //Log.i(location.name + ":", jsonStr);
        return new String[2] = {locationJSONStr, itemsJSONstr};
    }

    public Location deserializeLocation(String[] jsonStrs) {
        Location location = gson.fromJson(jsonStrs[0], LocationType);
        location.Items = gson.fromJson(jsonStrs[1], itemListType);
        return location;
    }
}