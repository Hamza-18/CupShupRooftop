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

public class Mocktails_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Mocktails_Adapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mocktails_drawer_layout);
        toolbar = findViewById(R.id.toolbar_mocktails);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Mocktails");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.lemonmojito);
        images.add(R.drawable.moctails);
        images.add(R.drawable.moctails);
        images.add(R.drawable.moctails);
        images.add(R.drawable.mintmargarita);
        images.add(R.drawable.moctails);
        images.add(R.drawable.moctails);
        images.add(R.drawable.moctails);
        images.add(R.drawable.moctails);
        images.add(R.drawable.moctails);
        images.add(R.drawable.moctails);
        images.add(R.drawable.moctails);


        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Lemon Mint Mojito");
        itemName.add("Guava Mint");
        itemName.add("Apple Lemonade");
        itemName.add("Pina Colada");
        itemName.add("Mint Margarita");
        itemName.add("Lemonade");
        itemName.add("Blueberry Fantasy");
        itemName.add("Peach Lagoon");
        itemName.add("Green Apple Lagoon");
        itemName.add("Blue Lagoon");
        itemName.add("Blue Berry Lagoon");
        itemName.add("Kiwi Lagoon");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("149");
        itemPrice.add("149");
        itemPrice.add("149");
        itemPrice.add("199");
        itemPrice.add("199");
        itemPrice.add("199");
        itemPrice.add("229");
        itemPrice.add("199");
        itemPrice.add("199");
        itemPrice.add("229");
        itemPrice.add("229");
        itemPrice.add("229");

        recyclerView = findViewById(R.id.mocktails_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Mocktails_Adapter(images, itemName, itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_mocktails);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });


    }
}
