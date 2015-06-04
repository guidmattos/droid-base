package com.guilhermeduartemattos.droidbase.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.guilhermeduartemattos.droidbase.R;
import com.guilhermeduartemattos.droidbase.adapter.FruitListAdapter;
import com.guilhermeduartemattos.droidbase.model.Fruit;
import com.guilhermeduartemattos.droidbase.model.FruitFactory;
import com.guilhermeduartemattos.droidbase.service.RestClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity implements Callback<JsonObject> {

    private ListView listView;
    private FruitListAdapter fruitAdapter;
    private ArrayList<Fruit> fruitArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
    }

    public void getViews() {
        listView = (ListView) findViewById(R.id.listView);
        RestClient.getInstance(this).getFruits(this);
    }

    @Override
    public void success(JsonObject jsonObject, Response response) {
        fruitArray = new ArrayList<>();
        JsonArray array = jsonObject.get("conteudo").getAsJsonArray();
        for (JsonElement element : array) {
            fruitArray.add(FruitFactory.create(element));
        }

        orderFruitsByValue();

        fruitAdapter = new FruitListAdapter(this, R.layout.list_view_item, fruitArray);
        listView.setAdapter(fruitAdapter);
    }

    private void orderFruitsByValue() {
        Collections.sort(fruitArray, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit fruit1, Fruit fruit2) {
                return Double.compare(fruit1.getValue(), fruit2.getValue());
            }

        });
    }

    @Override
    public void failure(RetrofitError error) {
        Log.e("ERROR", "Error trying to get fruits...");
    }
}
