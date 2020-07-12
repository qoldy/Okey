package com.example.okey;

import java.util.ArrayList;

public class Section {
    private String sectionName;
    private ArrayList<Product> productList;

    public Section(String name, ArrayList<Product> products)
    {
        sectionName = name;
        productList = products;
    }

    public String getSectionName() {return sectionName;}
    public ArrayList<Product> getProductList() {return productList;}
}
