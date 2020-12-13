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


public class Burgers_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Burgers_Adapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.burgers_drawer_layout);
        toolbar = findViewById(R.id.toolbar_burgers);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Burgers");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.burger);
        images.add(R.drawable.burger);
        images.add(R.drawable.burger);
        images.add(R.drawable.burger);
        images.add(R.drawable.burger);
        images.add(R.drawable.burger);
        images.add(R.drawable.some_burger);
        images.add(R.drawable.beef_burger);
        images.add(R.drawable.burger);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("BBQ Chicken Burger");
        itemName.add("Thunder Grilled Chicken Burger");
        itemName.add("Stuffed Jalapeno Chicken Burger");
        itemName.add("Swiss Mushroom Beef Burger");
        itemName.add("CupShup Special Beef Burger");
        itemName.add("The Double Cluck Beef Burger");
        itemName.add("Wild Beast Beef Burger");
        itemName.add("Hancock Beef Burger");
        itemName.add("Fish Fillet Burger");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("349");
        itemPrice.add("399");
        itemPrice.add("429");
        itemPrice.add("349");
        itemPrice.add("349");
        itemPrice.add("499");
        itemPrice.add("399");
        itemPrice.add("649");
        itemPrice.add("499");

        recyclerView = findViewById(R.id.recycler_burgers_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Burgers_Adapter(images, itemName, itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_burgers);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
    }
    }

