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

public class Fish_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Fish_Adapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fish_drawer_layout);
        toolbar = findViewById(R.id.toolbar_fish);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Fish");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.orange_sauce_fish);
        images.add(R.drawable.fish);
        images.add(R.drawable.fish);
        images.add(R.drawable.fish);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Orange Sauce Fish");
        itemName.add("Peanut Fish");
        itemName.add("Thai Red");
        itemName.add("Balsamic Glaze Fish");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("599");
        itemPrice.add("629");
        itemPrice.add("649");
        itemPrice.add("699");

        recyclerView = findViewById(R.id.fish_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Fish_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_fish);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });


    }
}
