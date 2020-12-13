package com.hamza.cupshuprooftop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    ArrayList<Items> dataSource;
    Context context;

    public CartAdapter(ArrayList<Items> dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_cart_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CartAdapter.ViewHolder holder, final int position) {
        holder.cart_itemName.setText(dataSource.get(position).getItemName());
        holder.cart_quantity.setText(dataSource.get(position).getItemQuantity());
        int price = Integer.parseInt(dataSource.get(position).getItemQuantity()) *
                Integer.parseInt(dataSource.get(position).getItemPrice());
        holder.cart_price.setText(price + "");
        holder.cart_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.cart_quantity.getText().toString());
                if (quantity > 1) {
                    quantity--;
                    holder.cart_quantity.setText(quantity + "");
                    int price = quantity * Integer.parseInt(dataSource.get(position).getItemPrice());
                    holder.cart_price.setText(price + "");
                }
                Menu_Activity.menuItems.get(position).setItemQuantity(quantity + "");
                Cart_Activity.setTotal();
            }
        });

        holder.cart_inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(holder.cart_quantity.getText().toString());
                quantity++;
                holder.cart_quantity.setText(quantity + "");
                int price = quantity * Integer.parseInt(dataSource.get(position).getItemPrice());
                holder.cart_price.setText(price + "");
                Menu_Activity.menuItems.get(position).setItemQuantity(quantity + "");
                Cart_Activity.setTotal();
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu_Activity.menuItems.remove(position);
                Cart_Activity.adapter.notifyDataSetChanged();
                Cart_Activity.setTotal();

            }
        });

//        Cart_Activity.total.setText(Cart_Activity.Total + "");

    }

    @Override
    public int getItemCount() {
        return Menu_Activity.menuItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button cart_inc;
        Button cart_dec;
        TextView cart_itemName;
        TextView cart_quantity;
        TextView cart_price;
        Button delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cart_inc = itemView.findViewById(R.id.cart_inc);
            cart_dec = itemView.findViewById(R.id.cart_dec);
            cart_itemName = itemView.findViewById(R.id.cart_item_name_id);
            cart_quantity = itemView.findViewById(R.id.cart_quantity_id);
            cart_price = itemView.findViewById(R.id.cart_price_id);
            delete = itemView.findViewById(R.id.delete_id);
        }
    }
}