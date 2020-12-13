package com.hamza.cupshuprooftop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class Menu_Activity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ImageView appetizers;
    ImageView burgers;
    ImageView salads;
    ImageView roulades;
    ImageView shakes;
    ImageView pasta;
    ImageView frappes;
    ImageView coffee;
    ImageView tea;
    ImageView kahwa;
    ImageView drinks;
    ImageView mocktails;
    ImageView steaks;
    ImageView pizza;
    ImageView sandwiches;
    ImageView fish;
    ImageView soup;
    ImageView fries;
    ImageView edit;
    TextView address_view;
    ProgressBar progressBar;
    FloatingActionButton fab;
    public static String address = "";
    public static ArrayList<Items> menuItems;
    boolean flag;
    ArrayList<Items> cartItems;
    String location;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_menu_layout);
        toolbar = findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Menu");
        menuItems = new ArrayList<>();

        edit = findViewById(R.id.edit_id);

        progressBar = findViewById(R.id.progressBar_id);
        progressBar.setVisibility(View.VISIBLE);

        fab = findViewById(R.id.fab_menu);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        address_view = findViewById(R.id.address_id);
        while (!flag) {
            if ("".equals(address)) {
                location = getIntent().getStringExtra("ADDRESS");
                address_view.setText(location);
                try {
                    MainActivity.customer.setAddress(location);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                flag = true;
            } else {
                address_view.setText(address);
                MainActivity.customer.setAddress(address);
                flag = true;
            }
        }

        if (MainActivity.mainMenu != null)
            menuItems = MainActivity.mainMenu;

        // set all the images
        appetizers = findViewById(R.id.appetizers_id);
        appetizers.setImageResource(R.drawable.appetizers);

        salads = findViewById(R.id.salads_id);
//        salads.setImageResource(R.drawable.salads);

        burgers = findViewById(R.id.burgers_id);
        burgers.setImageResource(R.drawable.burger);

        pizza = findViewById(R.id.pizza_id);
        pizza.setImageResource(R.drawable.pizza);

        fries = findViewById(R.id.fries_id);
        fries.setImageResource(R.drawable.fries);

        frappes = findViewById(R.id.frappes_id);
        frappes.setImageResource(R.drawable.frappes);

        drinks = findViewById(R.id.drinks_id);
        drinks.setImageResource(R.drawable.drinks);

        mocktails = findViewById(R.id.mocktails_id);
        mocktails.setImageResource(R.drawable.moctails);

        coffee = findViewById(R.id.coffee_id);
        coffee.setImageResource(R.drawable.coffee);

        tea = findViewById(R.id.tea_id);
//        tea.setImageResource(R.drawable.tea);

        kahwa = findViewById(R.id.kahwa_id);
        kahwa.setImageResource(R.drawable.kahwa);

        shakes = findViewById(R.id.shakes_id);
//        shakes.setImageResource(R.drawable.shakes);

        roulades = findViewById(R.id.roulades_id);
        roulades.setImageResource(R.drawable.roulades);

        pasta = findViewById(R.id.pasta_id);
        pasta.setImageResource(R.drawable.pasta);

        steaks = findViewById(R.id.steak_id);
//        steaks.setImageResource(R.drawable.steak);

        sandwiches = findViewById(R.id.sandwiches_id);
//        sandwiches.setImageResource(R.drawable.sandwiches);

        fish = findViewById(R.id.fish_id);
        fish.setImageResource(R.drawable.fish);

        soup = findViewById(R.id.soup_id);
//        soup.setImageResource(R.drawable.soup);

        progressBar.setVisibility(View.GONE);

        appetizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), appetizers_activity.class).
                        addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        salads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Salads.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        sandwiches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Sandwiches_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });


        burgers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Burgers_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Pizza_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Pasta_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        roulades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Roulades_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Fish_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        steaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Steaks_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Soup_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        fries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Fries_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        frappes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Frappes_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
        shakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Shakes_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        mocktails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Mocktails_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Drinks_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Coffee_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Tea_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        kahwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Kahwa_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Address_Activity.class).putExtra("ADDRESS_1",location)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });

        String menu = getIntent().getStringExtra("MENU");
        Type type = new TypeToken<ArrayList<Items>>() {
        }.getType();
        Gson gson = new Gson();
        cartItems = gson.fromJson(menu, type);
        if (cartItems != null)
            menuItems = cartItems;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (address.length() > 1) {
            location = address;
            address_view.setText(address);
            try {
                MainActivity.customer.setAddress(address);
            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            address_view.setText(location);
            try {
                MainActivity.customer.setAddress(location);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionsmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.contact_us) {
            startActivity(new Intent(getApplicationContext(), ContactUs_Activity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
        }
        else if(id == R.id.home){
            MainActivity.mainMenu = new ArrayList<>();
            MainActivity.mainMenu = menuItems;
            startActivity(new Intent(getApplicationContext(), MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainActivity.mainMenu = new ArrayList<>();
        MainActivity.mainMenu = menuItems;
    }
}
