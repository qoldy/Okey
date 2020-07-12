package com.example.okey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TemplateActivity extends AppCompatActivity {
    private ArrayList<Template> templateList;
    private TemplateAdapter templateAdt;
    private ListView templateView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        templateView = findViewById(R.id.template_list);
        templateList = (ArrayList<Template>)JSONHelper.importFromJSON(this);
        if(templateList!=null){
            templateAdt = new TemplateAdapter(this, templateList);
            templateView.setAdapter(templateAdt);
            Toast.makeText(this, "Данные восстановлены", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Не удалось открыть данные", Toast.LENGTH_LONG).show();
            templateList = new ArrayList<>();
        }
        templateAdt = new TemplateAdapter(this, templateList);
        templateView.setAdapter(templateAdt);
    }

    public void templatePicked(View view)
    {
        Integer tag = Integer.parseInt(view.getTag().toString());
        ((Okey)this.getApplication()).pannier.pannier=templateList.get(tag).getProducts();
        for(int i =0; i < ((Okey)this.getApplication()).pannier.pannier.size(); i++)
            ((Okey)this.getApplication()).pannier.pannier.get(i).templateCheck();
        Intent intent = new Intent(view.getContext(), MapActivity.class);
        startActivityForResult(intent, 0);
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MapActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onShopClick(View view){
        Intent intent = new Intent(this, MapActivity.class);
        ((Okey)this.getApplication()).pannier.clearPannier();
        startActivityForResult(intent, 0);
    }
}
