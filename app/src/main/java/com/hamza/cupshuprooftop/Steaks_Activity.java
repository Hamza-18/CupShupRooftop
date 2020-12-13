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

public class Steaks_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Steaks_Adapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steaks_drawer_layout);
        toolbar = findViewById(R.id.toolbar_steaks);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Steaks");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.steak);
        images.add(R.drawable.jalepeno_steak);
        images.add(R.drawable.steak);
        images.add(R.drawable.mexican_steak);
        images.add(R.drawable.steak);
        images.add(R.drawable.mushroom_steak);
        images.add(R.drawable.steak);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Taragon Chicken Steak");
        itemName.add("Jalapeno Chicken Steak");
        itemName.add("Black Pepper Chicken Steak");
        itemName.add("Mexican Chicken Steak");
        itemName.add("Morocon Chicken Steak");
        itemName.add("Mushroom Beef Steak");
        itemName.add("Meledone Beef Steak");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("529");
        itemPrice.add("529");
        itemPrice.add("549");
        itemPrice.add("579");
        itemPrice.add("599");
        itemPrice.add("649");
        itemPrice.add("699");

        recyclerView = findViewById(R.id.steaks_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Steaks_Adapter(images, itemName, itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_steaks);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
    }
}
