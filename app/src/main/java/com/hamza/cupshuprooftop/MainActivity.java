package com.hamza.cupshuprooftop;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    LocationManager locationManager;
    Geocoder geocoder;
    Address address;
    String houseAddress;
    TextView eT;
    EditText number;
    ProgressBar progressBar;
    TextView name;
    Button next;
    boolean flag;
    public static ArrayList<Items> mainMenu;
    public static Person customer;
    View constraintLayout;
    TextView promo;
    DatabaseReference databaseReference;
    String promoText = " ";
    public static String promoCode = "";
    ArrayList<String> promoArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

        // setup the toolbar
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("    CupShup Rooftop");
        toolbar.setLogo(R.mipmap.cupshup);
        progressBar = findViewById(R.id.progressBar_id);
        progressBar.setVisibility(View.GONE);

        promo = findViewById(R.id.promo_id);
        constraintLayout = findViewById(R.id.constraint_layout_id);
        number = findViewById(R.id.number_id);
        name = findViewById(R.id.name_id);

        if (isNetworkAvailable()) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION);
                flag = true;
            }// TODO: Consider calling

            if (flag = true) {
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "Please Wait", Toast.LENGTH_SHORT).show();
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);
            }
        } else
            Snackbar.make(constraintLayout, "No internet connection", Snackbar.LENGTH_LONG).show();
        // listener for next button
        next = findViewById(R.id.next_id);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer = new Person(name.getText().toString(), number.getText().toString());
                Intent intent = new Intent(getApplicationContext(), Menu_Activity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("ADDRESS", houseAddress);
                startActivity(intent);


            }
        });
        promoArray = new ArrayList<>();
        checkPromo();


    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sP = getSharedPreferences("FILE_1", 0);
        SharedPreferences.Editor editor = sP.edit();
        String phoneNumber = sP.getString("NUMBER", "");
        String nameSt = sP.getString("NAME", "");
        number.setText(phoneNumber);
        name.setText(nameSt);

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sP = getSharedPreferences("FILE_1", 0);
        SharedPreferences.Editor editor = sP.edit();
        editor.putString("NUMBER", number.getText().toString());
        editor.putString("ADDRESS", houseAddress);
        editor.putString("NAME", name.getText().toString());
        editor.apply();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.contact_us) {
            startActivity(new Intent(getApplicationContext(), ContactUs_Activity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
        }
        return true;
    }

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {
            List<Address> addresses = new ArrayList<>();
            geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            try {
                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                address = addresses.get(0);
                houseAddress = address.getAddressLine(0);
                progressBar.setVisibility(View.GONE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ArrayList<Items> menuItems = new ArrayList<>();
//        Gson gson = new Gson();
//        String menu = gson.toJson(menuItems);
//        SharedPreferences sP = getSharedPreferences("MENU_FILE", 0);
//        SharedPreferences.Editor editor = sP.edit();
//        editor.putString("MENU", menu);
//        editor.apply();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void checkPromo() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("CupShupRooftop/Promos");
        databaseReference.push().setValue(" ");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                promoArray.add(dataSnapshot.getValue(String.class));
                setPromo();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                promoArray.add(dataSnapshot.getValue(String.class));
                setPromo();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void setPromo() {
        for (int i = 0; i < promoArray.size(); i++) {
            if (!promoArray.get(i).equals(" "))
                promoText = promoArray.get(i);
        }
        if (!promoText.equals(" ")) {
            promo.setText(promoText);
            try {
                promoCode = promoText.substring(promoText.length() - 7);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class Person {
        private String customerName;
        private String phone;
        private String address;


        public Person(String name, String phone) {
            this.customerName = name;
            this.phone = phone;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public String getName() {
            return customerName;
        }

        public String getPhone() {
            return phone;
        }


        @NonNull
        @Override
        public String toString() {
            String info;
            info = String.format("Name: %s\n" +
                    "Phone number:%s\n" +
                    "Address:%s\n", customerName, phone, address);
            return info;
        }
    }
}
