package com.example.okey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PannierAdapter extends BaseAdapter {
    private ArrayList<Product> products;
    private LayoutInflater productInf;
    private LinearLayout productLay;

    public PannierAdapter(Context c, ArrayList<Product> p){
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
        Product currProduct = products.get(position);
        if(currProduct.getDiscount()==0)
        {

            productLay = (LinearLayout)productInf.inflate(R.layout.product_pannier,
                    parent, false);
            TextView productView = productLay.findViewById(R.id.product_title);
            productView.setText(currProduct.getProductName());
            productView = productLay.findViewById(R.id.product_price);
            productView.setText(Double.toString(currProduct.getPrice()) + "р.");
            productView = productLay.findViewById(R.id.product_amount);
            productView.setText(Integer.toString(currProduct.getAmount()));
        }
        else
        {
            productLay = (LinearLayout)productInf.inflate(R.layout.product_pannier_discount,
                    parent, false);
            TextView productView = productLay.findViewById(R.id.product_title);
            productView.setText(currProduct.getProductName());
            productView = productLay.findViewById(R.id.product_price);
            productView.setText(currProduct.getPrice() + "р.");
            productView = productLay.findViewById(R.id.discount);
            productView.setText("-" + currProduct.getDiscount() + "%");
            productView = productLay.findViewById(R.id.price);
            Double price = currProduct.getPriceWithDiscount();
            productView.setText(price + "р.");
            productView = productLay.findViewById(R.id.product_amount);
            productView.setText(Integer.toString(currProduct.getAmount()));
        }
        productLay.setTag(position);
        productLay.findViewById(R.id.addButton).setTag(position + "add");
        productLay.findViewById(R.id.product_amount).setTag(position + "amount");
        productLay.findViewById(R.id.deleteButton).setTag(position + "delete");
        productLay.findViewById(R.id.removeButton).setTag(position + "remove");
        return productLay;
    }
}