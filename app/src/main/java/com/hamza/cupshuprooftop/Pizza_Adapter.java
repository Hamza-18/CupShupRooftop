package com.hamza.cupshuprooftop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Pizza_Adapter extends RecyclerView.Adapter<Pizza_Adapter.ViewHolder> {
    ArrayList<Integer> itemImage;
    ArrayList<String> itemName;
    ArrayList<String> itemPrice;
    Items data;
    ArrayList<Pizza> pizzaFlavours;
    Pizza pizza;
    Context context;


    public Pizza_Adapter(ArrayList<Integer> image, ArrayList<String> itemName, ArrayList<String> itemPrice) {
        itemImage = image;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_card_view_layout, parent, false);
        ViewHolder holder = new ViewHolder(v);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.image_View.setImageResource(itemImage.get(position));
        holder.item_Name.setText(itemName.get(position));
        holder.price.setText(itemPrice.get(position));

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.quantity.getText().toString());
                quantity++;
                holder.quantity.setText(quantity + "");
            }
        });
        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.quantity.getText().toString());
                if (quantity > 1)
                    quantity--;
                holder.quantity.setText(quantity + "");

            }
        });

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean added = false;
                String itemName = holder.item_Name.getText().toString() + " size:" + holder.spinner.
                        getSelectedItem().toString();
                String itemPrice = holder.price.getText().toString();
                String itemQuantity = holder.quantity.getText().toString();
                data = new Items(itemName, itemQuantity, itemPrice);
                for (int i = 0; i < Menu_Activity.menuItems.size(); i++) {
                    if (Menu_Activity.menuItems.get(i).getItemName().equals(itemName)) {
                        Menu_Activity.menuItems.get(i).
                                setItemQuantity(Integer.parseInt(Menu_Activity.menuItems.get(i)
                                        .getItemQuantity()) + Integer.parseInt(itemQuantity) + "");
                        added = true;
                    }
                }
                if (!added)
                    Menu_Activity.menuItems.add(data);
                Toast.makeText(context,"Item Added to Cart",Toast.LENGTH_LONG).show();
            }
        });

        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).toString().equals("Small")) {
                    for (int i = 0; i < pizzaFlavours.size(); i++) {
                        if (pizzaFlavours.get(i).getFlavour().equals(holder.item_Name.getText().toString())) {
                            if (pizzaFlavours.get(i).getSize().equals("Small")) {
                                holder.price.setText(pizzaFlavours.get(i).getPrice());
                            }
                        }
                    }
                }

                if (parent.getItemAtPosition(position).toString().equals("Medium")) {
                    for (int i = 0; i < pizzaFlavours.size(); i++) {
                        if (pizzaFlavours.get(i).getFlavour().equals(holder.item_Name.getText().toString())) {
                            if (pizzaFlavours.get(i).getSize().equals("Medium")) {
                                holder.price.setText(pizzaFlavours.get(i).getPrice());
                            }
                        }
                    }
                }
                if (parent.getItemAtPosition(position).toString().equals("Large")) {
                    for (int i = 0; i < pizzaFlavours.size(); i++) {
                        if (pizzaFlavours.get(i).getFlavour().equals(holder.item_Name.getText().toString())) {
                            if (pizzaFlavours.get(i).getSize().equals("Large")) {
                                holder.price.setText(pizzaFlavours.get(i).getPrice());
                            }
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_View;
        TextView price;
        TextView item_Name;
        Button add;
        TextView item;
        TextView quantity;
        Button decrement;
        Button addToCart;
        Spinner spinner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_View = itemView.findViewById(R.id.image_pizza_id);
            item_Name = itemView.findViewById(R.id.pizza_item_id);
            price = itemView.findViewById(R.id.pizza_price_id);
            add = itemView.findViewById(R.id.increment_items_pizza_id);
            item = itemView.findViewById(R.id.pizza_item_id);
            quantity = itemView.findViewById(R.id.pizza_quantity_id);
            decrement = itemView.findViewById(R.id.decriment_items_pizza_id);
            addToCart = itemView.findViewById(R.id.pizza_add_id);
            spinner = itemView.findViewById(R.id.pizza_spinner);
        }
    }
}
