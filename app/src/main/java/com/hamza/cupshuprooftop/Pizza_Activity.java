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

public class Pizza_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    public static ArrayList<Pizza> pizzaFlavours;
    Pizza pizza;
    Pizza_Adapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_drawer_layout);
        toolbar = findViewById(R.id.toolbar_pizza);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Pizza");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.pizza);
        images.add(R.drawable.pizza);
        images.add(R.drawable.pizza);
        images.add(R.drawable.pizza);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Honey Garlic Chicken");
        itemName.add("BBQ Chicken Supreme");
        itemName.add("Super Supreme");
        itemName.add("Chicken Fajita");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("529");
        itemPrice.add("529");
        itemPrice.add("549");
        itemPrice.add("569");

        pizzaFlavours = new ArrayList<>();
        pizza = new Pizza("Honey Garlic Chicken", "Small", "529");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("Honey Garlic Chicken", "Medium", "929");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("Honey Garlic Chicken", "Large", "1229");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("BBQ Chicken Supreme", "Small", "529");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("BBQ Chicken Supreme", "Medium", "929");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("BBQ Chicken Supreme", "Large", "1229");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("Super Supreme", "Small", "549");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("Super Supreme", "Medium", "949");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("Super Supreme", "Large", "1249");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("Chicken Fajita", "Small", "569");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("Chicken Fajita", "Medium", "969");
        pizzaFlavours.add(pizza);
        pizza = new Pizza("Chicken Fajita", "Large", "1269");
        pizzaFlavours.add(pizza);

        recyclerView = findViewById(R.id.pizza_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Pizza_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_pizza);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

    }
}
