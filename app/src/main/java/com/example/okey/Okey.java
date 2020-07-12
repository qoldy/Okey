package com.example.okey;

import android.app.Application;

import java.util.ArrayList;

public class Okey extends Application {
    private Catalog catalog;
    public Catalog getCatalog ()
    {
        return catalog;
    }
    public void setCatalog(Catalog catalog) { this.catalog = catalog; }
    private Section currSection;
    public void setCurrSection(Section s){this.currSection = s;}
    public Section getCurrSection(){return currSection;}
    public Pannier pannier = new Pannier();
    public Integer tag = 0, hour = 15, minute = 30;
    public ArrayList<String> addressList = new ArrayList<>();
}
