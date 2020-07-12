package com.example.okey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class AddToTemplateActivity extends AppCompatActivity {
    EditText nameText;
    ArrayList<Template> templateList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_template);
        nameText = (EditText) findViewById(R.id.template_name);
        templateList = (ArrayList<Template>)JSONHelper.importFromJSON(this);
        if(templateList == null)
            templateList = new ArrayList<>();
    }

    public void onAddToTemplateClick(View view)
    {
        String name = nameText.getText().toString();
        if(name.equals(""))
            name = "Шаблон";
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);
        templateList.add(new Template(name, dateText + ", " + timeText,
                ((Okey)this.getApplication()).pannier.getPannier()));
        boolean result = JSONHelper.exportToJSON(this, templateList);
        if(result){
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Не удалось сохранить данные", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(view.getContext(), PannierActivity.class);
        startActivityForResult(intent, 0);
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, PannierActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onBackButtonClick(View view)
    {
        Intent intent = new Intent(view.getContext(), PannierActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onTemplatesClick(View view){
        Intent intent = new Intent(view.getContext(), TemplateActivity.class);
        startActivityForResult(intent, 0);
    }
}
