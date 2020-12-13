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

public class Coffee_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Coffee_Adapter adapter;
    FloatingActionButton fab;
    public static ArrayList<Coffee> coffeeSize;
    Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_drawer_layout);
        toolbar = findViewById(R.id.toolbar_coffee);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Coffee");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.coffee);
        images.add(R.drawable.coffee);
        images.add(R.drawable.some_coffee);
        images.add(R.drawable.coffee);
        images.add(R.drawable.coffee);
        images.add(R.drawable.coffee);
        images.add(R.drawable.coffee);
        images.add(R.drawable.coffee);
        images.add(R.drawable.coffee);
        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Espresso Shots");
        itemName.add("Americano");
        itemName.add("Cappuccino");
        itemName.add("Cafe Latte");
        itemName.add("Hot Chocolate");
        itemName.add("Hazelnut");
        itemName.add("Vanilla");
        itemName.add("Caramel");
        itemName.add("Mocha");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("149");
        itemPrice.add("199");
        itemPrice.add("199");
        itemPrice.add("199");
        itemPrice.add("199");
        itemPrice.add("249");
        itemPrice.add("249");
        itemPrice.add("249");
        itemPrice.add("249");

        coffeeSize = new ArrayList<>();
        coffee = new Coffee("Espresso Shots", "Small", "149");
        coffeeSize.add(coffee);
        coffee = new Coffee("Espresso Shots", "Medium", "199");
        coffeeSize.add(coffee);
        coffee = new Coffee("Espresso Shots", "Large", "249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Americano", "Small", "199");
        coffeeSize.add(coffee);
        coffee = new Coffee("Americano", "Medium", "249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Americano", "Large", "299");
        coffeeSize.add(coffee);
        coffee = new Coffee("Cappuccino", "Small", "199");
        coffeeSize.add(coffee);
        coffee = new Coffee("Cappuccino", "Medium", "249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Cappuccino", "Large", "299");
        coffeeSize.add(coffee);
        coffee = new Coffee("Cafe Latte", "Small", "199");
        coffeeSize.add(coffee);
        coffee = new Coffee("Cafe Latte", "Medium", "249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Cafe Latte", "Large", "299");
        coffeeSize.add(coffee);
        coffee = new Coffee("Hot Chocolate", "Small", "199");
        coffeeSize.add(coffee);
        coffee = new Coffee("Hot Chocolate", "Medium", "249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Hot Chocolate", "Large", "299");
        coffeeSize.add(coffee);
        coffee = new Coffee("Hazelnut", "Small", "249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Hazelnut", "Medium", "299");
        coffeeSize.add(coffee);
        coffee = new Coffee("Hazelnut", "Large", "329");
        coffeeSize.add(coffee);
        coffee = new Coffee("Vanilla","Small","249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Vanilla","Medium","299");
        coffeeSize.add(coffee);
        coffee = new Coffee("Vanilla","Large","329");
        coffeeSize.add(coffee);
        coffee = new Coffee("Caramel","Small","249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Caramel","Large","299");
        coffeeSize.add(coffee);
        coffee = new Coffee("Caramel","Large","329");
        coffeeSize.add(coffee);
        coffee = new Coffee("Mocha","Small","249");
        coffeeSize.add(coffee);
        coffee = new Coffee("Mocha","Medium","299");
        coffeeSize.add(coffee);
        coffee = new Coffee("Mocha","Large","329");
        coffeeSize.add(coffee);

        recyclerView = findViewById(R.id.coffee_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Coffee_Adapter(images, itemName, itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_coffee);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
    }

    public class Coffee {
        private String coffeeFlavour;
        private String coffeeSize;
        private String coffeePrice;

        public Coffee(String coffeeFlavour, String coffeeSize, String coffeePrice) {
            this.coffeeFlavour = coffeeFlavour;
            this.coffeeSize = coffeeSize;
            this.coffeePrice = coffeePrice;
        }

        public String getCoffeeFlavour() {
            return coffeeFlavour;
        }

        public String getCoffeeSize() {
            return coffeeSize;
        }

        public String getCoffeePrice() {
            return coffeePrice;
        }
    }
}
