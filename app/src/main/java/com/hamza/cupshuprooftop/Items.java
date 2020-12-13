package com.hamza.cupshuprooftop;

public class Items {
    private String itemName;
    private String itemQuantity;
    private String itemPrice;

    public Items(String itemName, String itemQuantity, String itemPrice) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public String getItemName(){return itemName;}

    public String getItemQuantity(){return itemQuantity;}

    public String getItemPrice(){return itemPrice;}

    public void setItemQuantity(String quantity){itemQuantity = quantity;}

}
