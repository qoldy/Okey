package com.example.okey;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRActivity extends AppCompatActivity {
    private QRAdapter qrAdt;
    private ListView productView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        QRGEncoder qrgEncoder = new QRGEncoder(getPannierString(), null, QRGContents.Type.TEXT, 1000);
        Bitmap bitmap;
        ImageView qrImage = findViewById(R.id.qrImage);
        try {
            bitmap = qrgEncoder.encodeAsBitmap();
            qrImage.setImageBitmap(bitmap);
        } catch (Exception e) {
            Log.v("exception", e.toString());
        }
        productView = findViewById(R.id.qr_list);
        qrAdt = new QRAdapter(this, ((Okey)this.getApplication()).pannier.getPannier());
        productView.setAdapter(qrAdt);
        TextView toPayView = findViewById(R.id.toPayText);
        toPayView.setText(((Okey)this.getApplication()).pannier.getToPay() + " р.");
        TextView addressView = findViewById(R.id.addressText);
        addressView.setText(((Okey)this.getApplication()).addressList.get
                (((Okey)this.getApplication()).tag));
        TextView codeView = findViewById(R.id.codeText);
        codeView.setText(getCode());
        TextView timeView = findViewById(R.id.timeText);
        if(((Okey)this.getApplication()).minute>9)
            timeView.setText(((Okey)this.getApplication()).hour + ":" +
                ((Okey)this.getApplication()).minute);
        else
            timeView.setText(((Okey)this.getApplication()).hour + ":0" +
                    ((Okey)this.getApplication()).minute);
    }

    private String getPannierString(){
        ArrayList<Product> pannier = ((Okey)this.getApplication()).pannier.getPannier();
        String result= (((Okey)this.getApplication()).tag) + ": ";
        for(int i=0; i<pannier.size(); i++)
        {
            result += pannier.get(i).id + " " + pannier.get(i).getAmount() + ", ";
        }
        return result;
    }
    public void onShopClick(View view){
        Intent intent = new Intent(this, MapActivity.class);
        ((Okey)this.getApplication()).pannier.clearPannier();
        startActivityForResult(intent, 0);
    }

    @Override
    public void onBackPressed() { }

    public void onTemplatesClick(View view){
        Intent intent = new Intent(view.getContext(), TemplateActivity.class);
        startActivityForResult(intent, 0);
    }

    private String getCode()
    {
        String code = "0000";
        int tag = ((Okey)this.getApplication()).tag;
        ArrayList<String> codes = (ArrayList<String>)JSONStrHelper.importFromJSON(this);
        if (codes==null)
        {
            codes = new ArrayList<>();
            codes.add("0999");
            codes.add("1999");
            codes.add("2999");
            codes.add("3999");
        }
        for(int i = 0; i < codes.size();i++)
        {
            if(codes.get(i).substring(0,1).equals(Integer.toString(tag)))
            {
                Integer codeInt = Integer.parseInt(codes.get(i).substring(1))+1;
                if(codeInt<10)
                    code = tag + "00" + codeInt;
                else if(codeInt < 100)
                {
                    code = tag + "0" + codeInt;
                }
                else if(codeInt < 1000)
                {
                    code = Integer.toString(tag)  + codeInt;
                }
                else
                    code = tag + "000";
                codes.add(code);
                codes.remove(i);
                JSONStrHelper.exportToJSON(this, codes);
                break;
            }
        }
        return code;
    }
}
