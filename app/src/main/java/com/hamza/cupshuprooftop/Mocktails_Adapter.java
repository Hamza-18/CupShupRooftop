package com.hamza.cupshuprooftop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mocktails_Adapter extends RecyclerView.Adapter<Mocktails_Adapter.ViewHolder> {
    ArrayList<Integer> itemImage;
    ArrayList<String> itemName;
    ArrayList<String> itemPrice;
    Context context;
    Items data;

    public Mocktails_Adapter(ArrayList<Integer> image, ArrayList<String> itemName, ArrayList<String> itemPrice) {
        itemImage = image;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
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
                holder.quantity.setText(quantity+"");
            }
        });
        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.quantity.getText().toString());
                if(quantity>1)
                    quantity--;
                holder.quantity.setText(quantity+"");

            }
        });

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = holder.item_Name.getText().toString();
                String itemPrice = holder.price.getText().toString();
                Boolean added = false;
                String itemQuantity = holder.quantity.getText().toString();
                data = new Items(itemName,itemQuantity,itemPrice);
                for(int i =0; i<Menu_Activity.menuItems.size();i++){
                    if(Menu_Activity.menuItems.get(i).getItemName().equals(itemName)){
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

        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_View = itemView.findViewById(R.id.image_id);
            item_Name = itemView.findViewById(R.id.item_id);
            price = itemView.findViewById(R.id.price_id);
            add = itemView.findViewById(R.id.increment_items_id);
            item = itemView.findViewById(R.id.item_id);
            quantity = itemView.findViewById(R.id.quantity_id);
            decrement = itemView.findViewById(R.id.decriment_items_id);
            addToCart = itemView.findViewById(R.id.add_id);
        }
    }
}
