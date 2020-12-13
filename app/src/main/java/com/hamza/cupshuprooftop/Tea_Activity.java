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

public class Tea_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Tea_Adapter adapter;
    FloatingActionButton fab;
    public static ArrayList<Tea> teaFlavour;
    Tea tea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tea_drawer_layout);
        toolbar = findViewById(R.id.toolbar_tea);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.cupshup);
        getSupportActionBar().setTitle("    Tea");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.karak);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);
        images.add(R.drawable.tea);

        ArrayList<String> itemName = new ArrayList<>();
        itemName.add("Karak");
        itemName.add("Doodh Patti");
        itemName.add("Cardamom");
        itemName.add("Fennel");
        itemName.add("Ginger");
        itemName.add("Cinnamon");
        itemName.add("Chocolate Tea");
        itemName.add("Coffee Tea");
        itemName.add("Pistachio Tea");
        itemName.add("Almond Tea");
        itemName.add("Malai Mar Ke");
        itemName.add("Masala Chai");
        itemName.add("Black Tea");
        itemName.add("Blue Berry Tea");

        teaFlavour = new ArrayList<>();
        tea = new Tea("Karak", "Small", "99");
        teaFlavour.add(tea);
        tea = new Tea("Karak", "Large", "129");
        teaFlavour.add(tea);
        tea = new Tea("Doodh Patti", "Small", "99");
        teaFlavour.add(tea);
        tea = new Tea("Doodh Patti", "Large", "129");
        teaFlavour.add(tea);
        tea = new Tea("Cardamom", "Small", "109");
        teaFlavour.add(tea);
        tea = new Tea("Cardamom", "Large", "139");
        teaFlavour.add(tea);
        tea = new Tea("Fennel", "Small", "109");
        teaFlavour.add(tea);
        tea = new Tea("Fennel", "Large", "139");
        teaFlavour.add(tea);
        tea = new Tea("Ginger", "Small", "109");
        teaFlavour.add(tea);
        tea = new Tea("Ginger", "Large", "139");
        teaFlavour.add(tea);
        tea = new Tea("Cinnamon", "Small", "109");
        teaFlavour.add(tea);
        tea = new Tea("Cinnamon", "Large", "139");
        teaFlavour.add(tea);
        tea = new Tea("Chocolate Tea", "Small", "119");
        teaFlavour.add(tea);
        tea = new Tea("Chocolate Tea", "Large", "149");
        teaFlavour.add(tea);
        tea = new Tea("Coffee Tea","Small","119");
        teaFlavour.add(tea);
        tea = new Tea("Coffee Tea","Large","149");
        teaFlavour.add(tea);
        tea = new Tea("Pistachio Tea","Small","119");
        teaFlavour.add(tea);
        tea = new Tea("Pistachio Tea","Large","149");
        teaFlavour.add(tea);
        tea = new Tea("Almond Tea","Small","119");
        teaFlavour.add(tea);
        tea = new Tea("Almond Tea","Large","149");
        teaFlavour.add(tea);
        tea = new Tea("Malai Mar Ke","Small","119");
        teaFlavour.add(tea);
        tea = new Tea("Malai Mar Ke","Large","149");
        teaFlavour.add(tea);
        tea = new Tea("Masala Chai","Small","129");
        teaFlavour.add(tea);
        tea = new Tea("Masala Chai","Large","149");
        teaFlavour.add(tea);
        tea = new Tea("Black Tea","Small","99");
        teaFlavour.add(tea);
        tea = new Tea("Black Tea","Large","129");
        teaFlavour.add(tea);
        tea = new Tea("Blue Berry Tea","Small","99");
        teaFlavour.add(tea);
        tea = new Tea("Blue Berry Tea","Large","129");
        teaFlavour.add(tea);

        ArrayList<String> itemPrice = new ArrayList<>();
        itemPrice.add("99");
        itemPrice.add("99");
        itemPrice.add("109");
        itemPrice.add("109");
        itemPrice.add("109");
        itemPrice.add("109");
        itemPrice.add("119");
        itemPrice.add("119");
        itemPrice.add("119");
        itemPrice.add("119");
        itemPrice.add("119");
        itemPrice.add("129");
        itemPrice.add("99");
        itemPrice.add("99");

        recyclerView = findViewById(R.id.tea_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Tea_Adapter(images,itemName,itemPrice);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab_tea);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart_Activity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
            }
        });
    }

    public class Tea {
        private String teaFlavour;
        private String teaSize;
        private String teaPrice;

        public Tea(String teaFlavour, String teaSize, String teaPrice) {
            this.teaFlavour = teaFlavour;
            this.teaSize = teaSize;
            this.teaPrice = teaPrice;
        }

        public String getTeaFlavour() {
            return teaFlavour;
        }

        public String getTeaPrice() {
            return teaPrice;
        }

        public String getTeaSize() {
            return teaSize;
        }
    }
}
