package com.example.okey;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PannierActivity extends AppCompatActivity {
    Pannier pannier;
    ArrayList<Product> productList;
    private PannierAdapter productAdt;
    private ListView productView;
    private TextView toPayView;
    private TextView hourTextView, minuteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pannier);
        pannier = ((Okey)this.getApplication()).pannier;
        pannier.check();
        productList = pannier.getPannier();
        productView = findViewById(R.id.pannier_list);
        productAdt = new PannierAdapter(this, productList);
        productView.setAdapter(productAdt);
        toPayView = this.findViewById(R.id.toPayTextView);
        toPayView.setText("К оплате: " + pannier.getToPay() + "р.");
        hourTextView = findViewById(R.id.hourText);
        hourTextView.setText(((Okey)this.getApplication()).hour + ":");
        minuteTextView = findViewById(R.id.minuteText);
        minuteTextView.setText(Integer.toString(((Okey)this.getApplication()).minute));

    }

    public void onMinusHourClick(View view)
    {
        ((Okey)this.getApplication()).hour-=1;
        if(((Okey)this.getApplication()).hour==-1)
            ((Okey)this.getApplication()).hour=23;
        hourTextView.setText(((Okey)this.getApplication()).hour + ":");
    }

    public void onPlusHourClick(View view)
    {
        ((Okey)this.getApplication()).hour+=1;
        if(((Okey)this.getApplication()).hour==24)
            ((Okey)this.getApplication()).hour=0;
        hourTextView.setText(((Okey)this.getApplication()).hour + ":");

    }

    public void onMinusMinuteClick(View view)
    {
        ((Okey)this.getApplication()).minute-=15;
        if(((Okey)this.getApplication()).minute==-15)
            ((Okey)this.getApplication()).minute=45;
        if(((Okey)this.getApplication()).minute>9)
            minuteTextView.setText(Integer.toString(((Okey)this.getApplication()).minute));
        else
            minuteTextView.setText("0" + ((Okey)this.getApplication()).minute);
    }

    public void onPlusMinuteClick(View view)
    {
        ((Okey)this.getApplication()).minute+=15;
        if(((Okey)this.getApplication()).minute==60)
            ((Okey)this.getApplication()).minute=0;
        if(((Okey)this.getApplication()).minute>9)
            minuteTextView.setText(Integer.toString(((Okey)this.getApplication()).minute));
        else
            minuteTextView.setText("0" + ((Okey)this.getApplication()).minute);
    }

    public void onAddButtonClick(View view)
    {
        Product product = productList.get
                (Integer.parseInt(view.getTag().toString().replaceAll("add","")));
        if(!product.addProduct())
        {
            Toast.makeText(this,
                    "К сожалению, данного продукта в данный момент нет на складе.",
                    Toast.LENGTH_LONG).show();

        }
        ((Okey)this.getApplication()).pannier.addToPannier(product);
        TextView amountView = productView.findViewWithTag
                (view.getTag().toString().replaceAll("add", "") + "amount");
        amountView.setText(Integer.toString(product.getAmount()));
        toPayView.setText("К оплате: " + pannier.getToPay() + "р.");
    }

    public void onDeleteButtonClick(View view)
    {
        Product product = productList.get
                (Integer.parseInt(view.getTag().toString().replaceAll("delete","")));
        product.deleteProduct();
        TextView amountView = productView.findViewWithTag
                (view.getTag().toString().replaceAll("delete", "") + "amount");
        amountView.setText(Integer.toString(product.getAmount()));
        toPayView.setText("К оплате: " + pannier.getToPay() + "р.");
    }

    public void onRemoveButtonClick(View view)
    {
        Product product = productList.get
                (Integer.parseInt(view.getTag().toString().replaceAll("remove","")));
        product.removeProduct();
        productList.remove
                (Integer.parseInt(view.getTag().toString().replaceAll("remove","")));
        productAdt = new PannierAdapter(this, productList);
        productView.setAdapter(productAdt);
        toPayView.setText("К оплате: " + pannier.getToPay() + "р.");
    }

    public void onToPayButtonClick(View view)
    {
            ((Okey) this.getApplication()).pannier.check();
            Intent intent = new Intent(this, QRActivity.class);
            startActivityForResult(intent, 0);
    }

    public void onBackButtonClick(View view){
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivityForResult(intent, 0);
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onTemplatesClick(View view){
        Intent intent = new Intent(view.getContext(), TemplateActivity.class);
        startActivityForResult(intent, 0);
    }
    public void onAddToTemplateClick(View view){
        Intent intent = new Intent(view.getContext(), AddToTemplateActivity.class);
        startActivityForResult(intent, 0);
    }
}
