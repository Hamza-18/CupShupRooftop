package com.hamza.cupshuprooftop;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class appetizers_activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Appetizers_Adapter adapter;
    TextView item;
    Button add;
    FloatingActionButton fab;
//    ExtendedFloatingActionButton fab;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_appetizer_layout);
        toolbar = findViewById(R.id.toolbar_appetizer);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Appetizers");

        ArrayList<Integer> itemImage = new ArrayList<>();
        itemImage.add(R.drawable.appetizers);
        itemImage.add(R.drawable.appetizers);
        itemImage.add(R.drawable.appetizers);
        itemImage.add(R.drawable.appetizers);
        itemImage.add(R.drawable.appetizers);
        itemImage.add(R.drawable.appetizers);
        itemImage.add(R.drawable.appetizers);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Red Dragon");
        itemName.add("Hot Shots");
        itemName.add("Potato Cheese Balls");
        itemName.add("Stuffed Chillies");
        itemName.add("Honey Chilli Wings");
        itemName.add("Chicken Croquettes");
        itemName.add("Fish and Chips");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("249");
        itemPrice.add("249");
        itemPrice.add("249");
        itemPrice.add("249");
        itemPrice.add("329");
        itemPrice.add("349");
        itemPrice.add("399");

        recyclerView = findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Appetizers_Adapter(itemImage, itemName, itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Cart_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

    }


}
