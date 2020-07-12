package com.example.okey;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SectionAdapter extends BaseAdapter {
    private ArrayList<String>  sections;
    private LayoutInflater sectionInf;
    private LinearLayout sectionLay;

    public SectionAdapter(Context c, ArrayList<String> s){
        sections = s;
        sectionInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {return sections.size();}

    @Override
    public Object getItem(int i) {return null;}

    @Override public long getItemId(int i) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            sectionLay = (LinearLayout)sectionInf.inflate(R.layout.section, parent, false);
            TextView sectionView = sectionLay.findViewById(R.id.section_title);
            String currSection = sections.get(position);
            sectionView.setText(currSection);
            sectionLay.setTag(position);
            return sectionLay;
    }
}
