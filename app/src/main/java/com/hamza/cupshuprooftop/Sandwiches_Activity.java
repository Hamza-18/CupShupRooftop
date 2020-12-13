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


public class Sandwiches_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Sandwiches_Adapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sandwiches_drawer_layout);
        toolbar = findViewById(R.id.toolbar_sandwiches);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Sandwiches");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.cupshup_sandwich);
        images.add(R.drawable.sandwiches);
        images.add(R.drawable.sandwiches);
        images.add(R.drawable.panini);
        images.add(R.drawable.sandwiches);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("CupShup Sandwich");
        itemName.add("Taco Sandwich");
        itemName.add("Fillet Cheese Sandwich");
        itemName.add("Panini Sandwich");
        itemName.add("Survey Sandwich");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("299");
        itemPrice.add("329");
        itemPrice.add("349");
        itemPrice.add("379");
        itemPrice.add("399");

        recyclerView = findViewById(R.id.recycler_sanwiches_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Sandwiches_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_sandwiches);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });


    }
}
