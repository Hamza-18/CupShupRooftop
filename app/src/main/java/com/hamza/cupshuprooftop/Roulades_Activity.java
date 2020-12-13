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


public class Roulades_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Roulades_Adapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roulades_drawer_layout);
        toolbar = findViewById(R.id.toolbar_roulades);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Roulades");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.roulades);
        images.add(R.drawable.roulades);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Polo Chicken");
        itemName.add("Chicken Alakive");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("599");
        itemPrice.add("679");

        recyclerView = findViewById(R.id.roulades_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Roulades_Adapter(images, itemName, itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_roulades);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

    }
}
