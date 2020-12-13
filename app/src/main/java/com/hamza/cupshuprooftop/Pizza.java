package com.hamza.cupshuprooftop;

public class Pizza {
    private String flavour;
    private String size;
    private String price;

    public Pizza(String flavour,String size, String price){
        this.flavour = flavour;
        this.price = price;
        this.size = size;
    }

    public String getFlavour(){return flavour;}

    public String getPrice(){return price;}

    public String getSize(){return size;}
}
