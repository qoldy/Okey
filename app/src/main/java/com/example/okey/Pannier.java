package com.example.okey;

import java.util.ArrayList;

public class Pannier {
    public ArrayList<Product> pannier = new ArrayList<>();
    public void addToPannier(Product product)
    {
        if(!pannier.contains(product))
            pannier.add(product);
    }
    public void check()
    {
        int size = pannier.size();
        for(int i = 0; i < size; i++) {
            if (pannier.get(i).getAmount() == 0) {
                pannier.remove(i);
                size -= 1;
            }
        }
    }
    public void clearPannier(){
        for(int i = 0; i < pannier.size(); i++)
        {
            pannier.get(i).clear();
        }
        pannier.clear();
    }
    public ArrayList<Product> getPannier(){return pannier;}
    public Double getToPay(){
        Double pay = 0.0;
        for(int i = 0; i < pannier.size(); i++)
        {
            if(pannier.get(i).getDiscount() == 0)
                pay += pannier.get(i).getPrice()*pannier.get(i).getAmount();
            else
                pay += pannier.get(i).getPriceWithDiscount()*pannier.get(i).getAmount();
        }
        return Math.round(pay*100)/100.0;
    }

    public Integer getPannierAmount(){
        Integer amount = 0;
        for(int i=0; i < pannier.size(); i++)
            amount += pannier.get(i).getAmount();
        return amount;
    }
}
