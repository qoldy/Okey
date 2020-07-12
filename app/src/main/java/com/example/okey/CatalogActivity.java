package com.example.okey;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class CatalogActivity extends AppCompatActivity {
    private ListView sectionView;
    private SectionAdapter sectionAdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        sectionView = findViewById(R.id.section_list);
        sectionAdt = new SectionAdapter(this, ((Okey) this.getApplication()).getCatalog().getSectionNameList());
        sectionView.setAdapter(sectionAdt);
        Button pannierButton = findViewById(R.id.pannierCatalog);
        pannierButton.setText(Integer.toString(((Okey)this.getApplication()).pannier.getPannierAmount()));
    }

    public void sectionPicked(View view)
    {
        Intent intent = new Intent(view.getContext(), SectionActivity.class);
        ((Okey) this.getApplication()).setCurrSection(((Okey)this.getApplication()).getCatalog().
                getSectionList().get((Integer.parseInt(view.getTag().toString()))));
        startActivityForResult(intent, 0);
    }
    public void onPannierButtonClick(View view)
    {
        Intent intent = new Intent(view.getContext(), PannierActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MapActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onBackButtonClick(View view)
    {
        Intent intent = new Intent(view.getContext(), MapActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onTemplatesClick(View view){
        Intent intent = new Intent(view.getContext(), TemplateActivity.class);
        startActivityForResult(intent, 0);
    }
}
