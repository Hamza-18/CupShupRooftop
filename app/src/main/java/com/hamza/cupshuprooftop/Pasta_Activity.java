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

public class Pasta_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Pasta_Adapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasta_drawer_layout);
        toolbar = findViewById(R.id.toolbar_pasta);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Pasta");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.creamy_pasta);
        images.add(R.drawable.pasta);
        images.add(R.drawable.alfredo_pasta);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Creamy Cheese Pasta");
        itemName.add("CupShup Special Pasta");
        itemName.add("Alfredo Pasta");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("399");
        itemPrice.add("379");
        itemPrice.add("399");

        recyclerView = findViewById(R.id.pasta_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Pasta_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_pasta);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

    }
}
