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

public class Frappes_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton fab;
    Frappes_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frappes_drawer_layout);
        toolbar = findViewById(R.id.toolbar_frappes);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Frappes");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.frappes);
        images.add(R.drawable.frappes);
        images.add(R.drawable.frappes);
        images.add(R.drawable.frappes);
        images.add(R.drawable.frappes);
        images.add(R.drawable.cookies_cream);
        images.add(R.drawable.frappes);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Mocha Mint Frappe");
        itemName.add("Choco Frappe");
        itemName.add("Irish Frappe");
        itemName.add("Caramel Frappe");
        itemName.add("Vanilla Frappe");
        itemName.add("Cookies and Cream Frappe");
        itemName.add("Hazelnut Frappe");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("199");
        itemPrice.add("229");
        itemPrice.add("229");
        itemPrice.add("249");
        itemPrice.add("249");
        itemPrice.add("249");
        itemPrice.add("249");

        recyclerView= findViewById(R.id.frappes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Frappes_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_frappes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });


    }
}
