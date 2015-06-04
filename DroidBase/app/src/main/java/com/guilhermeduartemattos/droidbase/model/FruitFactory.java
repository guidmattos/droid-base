package com.guilhermeduartemattos.droidbase.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by guilhermeduartemattos on 6/4/15.
 */
public class FruitFactory {

    public static Fruit create(JsonElement jsonElement) {

        JsonObject jsonObject = (JsonObject) jsonElement;
        String title = jsonObject.get("title").getAsString();
        String description = jsonObject.get("description").getAsString();
        String imgUrl = jsonObject.get("image").getAsString();
        double value = jsonObject.get("valor").getAsDouble();

        Fruit fruit = new Fruit(imgUrl, title, description, value);
        return fruit;
    }
}
