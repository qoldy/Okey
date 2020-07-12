package com.example.okey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TemplateAdapter extends BaseAdapter {
    private ArrayList<Template> templates;
    private LayoutInflater templateInf;
    private LinearLayout templateLay;

    public TemplateAdapter(Context c, ArrayList<Template> t){
        templates = t;
        templateInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {return templates.size();}

    @Override
    public Object getItem(int i) {return null;}

    @Override public long getItemId(int i) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        templateLay = (LinearLayout)templateInf.inflate(R.layout.template, parent, false);
        TextView templateView = templateLay.findViewById(R.id.template_title);
        Template currTemplate = templates.get(position);
        templateView.setText(currTemplate.name);
        templateView = templateLay.findViewById(R.id.template_date);
        templateView.setText(currTemplate.date);
        templateLay.setTag(position);
        return templateLay;
    }
}

