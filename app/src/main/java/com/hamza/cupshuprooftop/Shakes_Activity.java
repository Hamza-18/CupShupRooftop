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

public class Shakes_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Shakes_Adapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shakes_drawer_layout);
        toolbar = findViewById(R.id.toolbar_shakes);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("   Shakes");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.cold_coffee);
        images.add(R.drawable.shakes);
        images.add(R.drawable.shakes);
        images.add(R.drawable.shakes);
        images.add(R.drawable.shakes);
        images.add(R.drawable.oreo_shake);
        images.add(R.drawable.kitkat_shake);
        images.add(R.drawable.shakes);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Coffee");
        itemName.add("Caramel");
        itemName.add("Chocolate");
        itemName.add("Strawberry");
        itemName.add("Vanilla");
        itemName.add("Oreo");
        itemName.add("Kitkat");
        itemName.add("Snicker");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("249");
        itemPrice.add("279");
        itemPrice.add("299");
        itemPrice.add("299");
        itemPrice.add("299");
        itemPrice.add("299");
        itemPrice.add("329");
        itemPrice.add("329");

        recyclerView = findViewById(R.id.shakes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Shakes_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_shakes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

    }
}
