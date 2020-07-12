package com.example.okey;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class Catalog {
    private ArrayList<Section> sectionList;
    private ArrayList<String> sectionNameList;

    public Catalog()
    {
        sectionList = new ArrayList<>();
        sectionNameList = new ArrayList<>();
    }

    public void addSection(Section s)
    {
        sectionList.add(s);
        sectionNameList.add(s.getSectionName());
    }

    public ArrayList<Section> getSectionList()
    {
        return sectionList;
    }
    public ArrayList<String> getSectionNameList(){return sectionNameList;}
}
