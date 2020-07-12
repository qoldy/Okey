package com.example.okey;

import java.util.ArrayList;

public class Template {
    public String name;
    public String date;
    private ArrayList<Product> products;
    Template(String name, String date, ArrayList<Product> p){
        this.name = name;
        this.date = date;
        products = p;
    }
    public ArrayList<Product> getProducts(){return products;}
}
