package com.hamza.cupshuprooftop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Kahwa_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Kahwa_Adapter adapter;
    FloatingActionButton fab;
    public static ArrayList<Kahwa> kahwaFlavour;
    Kahwa kahwa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kahwa_drawer_layout);
        toolbar = findViewById(R.id.toolbar_kahwa);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Kahwa");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.kahwa);
        images.add(R.drawable.kahwa);
        images.add(R.drawable.kahwa);
        images.add(R.drawable.kahwa);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Green Tea");
        itemName.add("Sulemani Kahwa");
        itemName.add("Lemon Grass");
        itemName.add("Peshawari Kahwa");

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("99");
        itemPrice.add("99");
        itemPrice.add("109");
        itemPrice.add("109");

        kahwaFlavour = new ArrayList<>();
        kahwa = new Kahwa("Green Tea","Small",  "99");
        kahwaFlavour.add(kahwa);
        kahwa = new Kahwa("Green Tea","Large",  "129");
        kahwaFlavour.add(kahwa);
        kahwa = new Kahwa("Sulemani Kahwa","Small",  "99");
        kahwaFlavour.add(kahwa);
        kahwa = new Kahwa("Sulemani Kahwa","Large",  "129");
        kahwaFlavour.add(kahwa);
        kahwa = new Kahwa("Lemon Grass","Small",  "109");
        kahwaFlavour.add(kahwa);
        kahwa = new Kahwa("Lemon Grass","Large",  "129");
        kahwaFlavour.add(kahwa);
        kahwa = new Kahwa("Peshawari Kahwa","Small",  "109");
        kahwaFlavour.add(kahwa);
        kahwa = new Kahwa("Peshawari Kahwa","Large",  "129");
        kahwaFlavour.add(kahwa);

        recyclerView = findViewById(R.id.kahwa_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Kahwa_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_kawhwa);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

    }
    public class Kahwa{
        private String kahwaFlavour;
        private String kahwaSize;
        private String kahwaPrice;

        public Kahwa(String kahwaFlavour,String kahwaSize, String kahwaPrice){
            this.kahwaFlavour = kahwaFlavour;
            this.kahwaSize = kahwaSize ;
            this.kahwaPrice = kahwaPrice;
        }

        public String getKahwaFlavour() {
            return kahwaFlavour;
        }

        public String getKahwaPrice() {
            return kahwaPrice;
        }

        public String getKahwaSize() {
            return kahwaSize;
        }
    }
}
