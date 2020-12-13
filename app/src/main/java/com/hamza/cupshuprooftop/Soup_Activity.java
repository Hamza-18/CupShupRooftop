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

public class Soup_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Soup_Adapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soups_drawer_layout);
        toolbar = findViewById(R.id.toolbar_soup);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Soup");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.soup);
        images.add(R.drawable.soup);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Chicken Corn Soup");
        itemName.add("Hot N Sour Soup");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("199");
        itemPrice.add("229");

        recyclerView = findViewById(R.id.soup_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Soup_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_soups);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
    }
}
