package com.hamza.cupshuprooftop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Salads extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Salads_Adapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salads_drawer_layout);
        toolbar = findViewById(R.id.toolbar_salads);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Salads");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.salads);
        images.add(R.drawable.salads);
        images.add(R.drawable.salads);
        images.add(R.drawable.ceaser_salad);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Chicken Pineapple Salad");
        itemName.add("Chicken Mushroom Salad");
        itemName.add("Russian Salad");
        itemName.add("Caeser Salad");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("249");
        itemPrice.add("279");
        itemPrice.add("279");
        itemPrice.add("299");

        // set up the recycler view
        recyclerView = findViewById(R.id.recycler_salads_view_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Salads_Adapter(images, itemName, itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_salads);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
    }


}
