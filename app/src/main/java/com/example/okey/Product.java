package com.example.okey;

import android.os.CountDownTimer;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Product {
    private String productName;
    private Double price;
    private Integer discount;
    public int id;
    private int amount = 0;
    private int storageAmount = 30;
    private int shelf_life = 0;

    public Product(String n, Double p, Integer d, int i)
    {
        productName = n;
        price = p;
        discount = d;
        id = i;
    }

    public Double getPrice()
    {
        return price;
    }

    public String getProductName()
    {
        return productName;
    }

    public Integer getDiscount()
    {
        return discount;
    }

    public Double getPriceWithDiscount(){return (Math.round(price*(100-discount)*0.01*100.0))/100.0;}

    public boolean addProduct(){
        if(storageAmount!=0) {
            amount += 1;
            storageAmount -= 1;
            return true;
        }
        return false;
    }
    public void deleteProduct(){amount -= 1; if(amount<0) amount = 0; else storageAmount += 1;}
    public void removeProduct(){storageAmount+=amount; amount = 0;}
    public int getAmount(){return amount;}
    public void clear(){
        amount = 0;
    if(storageAmount==0)
        {
        new CountDownTimer(60000,5000) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                storageAmount = 30;
            }
        };
        }
    }
    public void templateCheck()
    {
        for(int i = 0; i < amount; i++)
        {
            storageAmount-=1;
            if(storageAmount==0) {
                amount = i + 1;
                break;
            }
        }
    }
    public String getShelf_life(){
        if(shelf_life!=0) {
            Date currentDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DATE, shelf_life);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            return "Годен до:" + dateFormat.format(calendar.getTime());
        }
        return "0";
    }

    public void setShelf_life(int shelf_life){this.shelf_life = shelf_life;}
}
