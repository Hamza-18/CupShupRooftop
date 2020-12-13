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

public class Fries_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Fries_Adapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fries_drawer_layout);
        toolbar = findViewById(R.id.toolbar_fries);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Fries");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.fries);
        images.add(R.drawable.fries);
        images.add(R.drawable.fries);
        images.add(R.drawable.fries);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Plain Fries");
        itemName.add("Masala Fries");
        itemName.add("Cheese Fries");
        itemName.add("Loaded Fries");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("179");
        itemPrice.add("199");
        itemPrice.add("249");
        itemPrice.add("349");

        recyclerView = findViewById(R.id.fries_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Fries_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_fries);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
    }
}
