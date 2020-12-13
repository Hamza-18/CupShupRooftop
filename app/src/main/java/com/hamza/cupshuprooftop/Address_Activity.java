package com.hamza.cupshuprooftop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Address_Activity extends AppCompatActivity {
    Toolbar toolbar;
    TextView address_view;
    Button save;
    public static boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_drawer_layout);
        toolbar = findViewById(R.id.toolbar_address);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Address");
        address_view = findViewById(R.id.edit_address_id);
        save = findViewById(R.id.save_id);


        String address = getIntent().getStringExtra("ADDRESS_1");
        address_view = findViewById(R.id.edit_address_id);
        address_view.setText(address);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu_Activity.address = address_view.getText().toString();
                flag = true;
                Toast.makeText(getApplicationContext(),"Address has been saved",Toast.LENGTH_LONG).show();
            }
        });
    }
}
