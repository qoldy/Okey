package com.example.okey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SectionActivity extends AppCompatActivity {
    private ProductAdapter productAdt;
    private ListView productView;
    private Section section;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        TextView sectionName = findViewById(R.id.sectionView);
        section = ((Okey)this.getApplication()).getCurrSection();
        sectionName.setText(section.getSectionName());
        productView = findViewById(R.id.product_list);
        productAdt = new ProductAdapter(this, section.getProductList());
        productView.setAdapter(productAdt);
        productList = section.getProductList();
        Button pannierButton = findViewById(R.id.pannierSection);
        pannierButton.setText(Integer.toString(((Okey)this.getApplication()).pannier.getPannierAmount()));
    }

    public void onAddButtonClick(View view)
    {
        Product product = productList.get(Integer.parseInt(view.getTag().toString().replaceAll("add","")));
        if(!product.addProduct())
        {
            Toast.makeText(this, "К сожалению, данного продукта в данный момент нет на складе.",
                    Toast.LENGTH_LONG).show();
        }
        else
            ((Okey)this.getApplication()).pannier.addToPannier(product);
        TextView amountView = productView.findViewWithTag(view.getTag().toString().replaceAll("add", "") + "amount");
        amountView.setText(Integer.toString(product.getAmount()));
        Button pannierButton = findViewById(R.id.pannierSection);
        pannierButton.setText(Integer.toString(((Okey)this.getApplication()).pannier.getPannierAmount()));
    }
    public void onDeleteButtonClick(View view)
    {
        Product product = productList.get(Integer.parseInt(view.getTag().toString().replaceAll("delete","")));
        product.deleteProduct();
        ((Okey)this.getApplication()).pannier.addToPannier(product);
        TextView amountView = productView.findViewWithTag(view.getTag().toString().replaceAll("delete", "") + "amount");
        amountView.setText(Integer.toString(product.getAmount()));
        Button pannierButton = findViewById(R.id.pannierSection);
        pannierButton.setText(Integer.toString(((Okey)this.getApplication()).pannier.getPannierAmount()));
    }

    public void onBackButtonClick(View view)
    {
        Intent intent = new Intent(view.getContext(), CatalogActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onPannierButtonClick(View view)
    {
        Intent intent = new Intent(view.getContext(), PannierActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onTemplatesClick(View view){
        Intent intent = new Intent(view.getContext(), TemplateActivity.class);
        startActivityForResult(intent, 0);
    }
}
