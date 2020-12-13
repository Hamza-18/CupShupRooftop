package com.hamza.cupshuprooftop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;

public class Cart_Activity extends AppCompatActivity {
    Toolbar toolbar;
    public static CartAdapter adapter;
    RecyclerView recyclerView;
    public static int totalPrice;
    public static TextView total;
    Button checkout;
    Button clear;
    String order;
    DatabaseReference myRef;
    View constraintLayout;
    static TextView description;
    static TextView promo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_drawer_layout);
        toolbar = findViewById(R.id.toolbar_cart);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        Objects.requireNonNull(getSupportActionBar()).setTitle("    Shopping cart");

        constraintLayout = findViewById(R.id.constrain_layout_id);
        recyclerView = findViewById(R.id.cart_recyclerView_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(Menu_Activity.menuItems);
        recyclerView.setAdapter(adapter);

        promo = findViewById(R.id.promo_cart_id);
        description = findViewById(R.id.description_id);
        total = findViewById(R.id.total_id);
        clear = findViewById(R.id.clear_id);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu_Activity.menuItems = new ArrayList<>();
                MainActivity.mainMenu = new ArrayList<>();
                totalPrice = 0;
                total.setText("");
                adapter.notifyDataSetChanged();

            }
        });
        setTotal();
        if(!promo.getText().toString().equals(""))
            setTotal();
        if (isNetworkAvailable()) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            myRef = database.getReference("CupShupRooftop/Orders");
            checkout = findViewById(R.id.order_id);
            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Menu_Activity.menuItems.size() > 0) {
                            if (checkPromo()) {
                                Snackbar.make(v, "Place Order?", Snackbar.LENGTH_LONG).
                                        setAction("Confirm", new View.OnClickListener() {
                                            @SuppressLint("DefaultLocale")
                                            @Override
                                            public void onClick(View v) {
                                                setTotal();
                                                order = MainActivity.customer.toString();
                                                for (int i = 0; i < Menu_Activity.menuItems.size(); i++) {
                                                    order += String.format(" itm # %s, qty # %s\n",
                                                            Menu_Activity.menuItems.get(i).getItemName(),
                                                            Menu_Activity.menuItems.get(i).getItemQuantity());
                                                }
                                                order += String.format("\nTotal: %d", totalPrice);
                                                if (!description.getText().toString().equals(""))
                                                    order += String.format("\n Description:  %s",
                                                            description.getText().toString());
                                                myRef.push().setValue(order);
                                                Toast.makeText(getApplicationContext(), "Order has been placed",
                                                        Toast.LENGTH_LONG).show();
                                            }
                                        }).show();
                            } else
                                Toast.makeText(getApplicationContext(), "Promo code is wrong", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getApplicationContext(), "Your Cart is Empty", Toast.LENGTH_LONG).show();
                }
            });

        } else {
            Snackbar.make(constraintLayout, "No internet connection", Snackbar.LENGTH_LONG).show();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu) {
            Gson gson = new Gson();
            String menu = gson.toJson(Menu_Activity.menuItems);
            Intent intent = new Intent(getApplicationContext(), Menu_Activity.class);
            intent.putExtra("MENU", menu);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
        else if (id == R.id.home){
            MainActivity.mainMenu = new ArrayList<>();
            MainActivity.mainMenu = Menu_Activity.menuItems;
            startActivity(new Intent(getApplicationContext(), MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        totalPrice = 0;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        setTotal();
        adapter.notifyDataSetChanged();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void setTotal() {
        totalPrice = 0;
        for (int i = 0; i < Menu_Activity.menuItems.size(); i++) {
            totalPrice += Integer.parseInt(Menu_Activity.menuItems.get(i).getItemQuantity()) *
                    Integer.parseInt(Menu_Activity.menuItems.get(i).getItemPrice());
        }
        if (!promo.getText().toString().equals("")) {
            if (checkPromo()) {
                double promo = Integer.parseInt(MainActivity.promoCode.
                        substring(MainActivity.promoCode.length() - 2));
                double discount = (promo / 100.00) * totalPrice;
                totalPrice -= discount;
            }
        }
        totalPrice += totalPrice*0.16;
        total.setText(totalPrice + "");
    }

    public static boolean checkPromo() {
        if (!promo.getText().toString().equals("")) {
            return MainActivity.promoCode.equals(promo.getText().toString());
        } else
            return true;
    }


}
