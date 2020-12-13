package com.hamza.cupshuprooftop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Drinks_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Drinks_Adapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinks_drawer_layout);
        toolbar = findViewById(R.id.toolbar_drinks);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Drinks");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.drinks);
        images.add(R.drawable.drinks);
        images.add(R.drawable.drinks);
        images.add(R.drawable.drinks);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Water Small");
        itemName.add("Soft Drink Can");
        itemName.add("Fresh Lime");
        itemName.add("Red Bull");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("44");
        itemPrice.add("59");
        itemPrice.add("119");
        itemPrice.add("295");

        recyclerView = findViewById(R.id.drinks_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Drinks_Adapter(images, itemName, itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_drinks);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
    }
}
