package com.example.okey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class QRAdapter extends BaseAdapter {
    private ArrayList<Product> products;
    private LayoutInflater productInf;
    private LinearLayout productLay;

    public QRAdapter(Context c, ArrayList<Product> p){
        products = p;
        productInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {return products.size();}

    @Override
    public Object getItem(int i) {return null;}

    @Override public long getItemId(int i) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        productLay = (LinearLayout)productInf.inflate(R.layout.product_qr, parent, false);
        TextView productView = productLay.findViewById(R.id.qr_title);
        Product currProduct = products.get(position);
        productView.setText(currProduct.getProductName());
        productView = productLay.findViewById(R.id.qr_amount);
        productView.setText(Integer.toString(currProduct.getAmount()));
        productView = productLay.findViewById(R.id.qr_price);
        if(currProduct.getDiscount()==0)
            productView.setText(Math.round(currProduct.getPrice() * currProduct.getAmount()*100)/100 + " р.");
        else
            productView.setText(Math.round(currProduct.getPriceWithDiscount()*currProduct.getAmount()*100)/100 + " р.");
        productLay.setTag(position);
        return productLay;
    }
}