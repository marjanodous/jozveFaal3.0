package com.example.jozvefaal30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jozvefaal30.adapter.adapter_menu_maqalat;
import com.example.jozvefaal30.adapter.adapter_menu_omumi;
import com.example.jozvefaal30.adapter.adapter_menu_takhsosi;

public class tozihat extends AppCompatActivity {
    TextView book_name, reshte, enteshar, upload, uni, ostad, book_price, tozihat;
    ImageView img_avatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tozihat);
        book_name = findViewById(R.id.book_name);
        reshte = findViewById(R.id.reshte);
        enteshar = findViewById(R.id.enteshar);
        upload = findViewById(R.id.upload);
        uni = findViewById(R.id.uni);
        ostad = findViewById(R.id.ostad);
        book_price = findViewById(R.id.book_price);
        tozihat = findViewById(R.id.tozihat);
        img_avatar = findViewById(R.id.img_avatar);

        if (adapter_menu_omumi.flag_omumi == true) {
            Bundle bundle = getIntent().getExtras();
            book_name.setText(bundle.getString("book_name"));
            reshte.setText(bundle.getString("reshte"));
            enteshar.setText(bundle.getString("enteshar"));
            upload.setText(bundle.getString("uplode"));
            uni.setText(bundle.getString("daneshgah"));
            ostad.setText(bundle.getString("ostad_name"));
            book_price.setText(bundle.getString("book_price"));
            tozihat.setText(bundle.getString("tozihat"));
            img_avatar.setImageResource(bundle.getInt("image_avatar"));
        }else if (adapter_menu_takhsosi.flag_takhasosi == true){
            Bundle bundle = getIntent().getExtras();
            book_name.setText(bundle.getString("book_name_ta"));
            reshte.setText(bundle.getString("reshte_ta"));
            enteshar.setText(bundle.getString("enteshar_ta"));
            upload.setText(bundle.getString("uplode_ta"));
            uni.setText(bundle.getString("daneshgah_ta"));
            ostad.setText(bundle.getString("ostad_name_ta"));
            book_price.setText(bundle.getString("book_price_ta"));
            tozihat.setText(bundle.getString("tozihat_ta"));
            img_avatar.setImageResource(bundle.getInt("image_avatar_ta"));
        }else if (adapter_menu_maqalat.flag_maqalat == true){
            Bundle bundle = getIntent().getExtras();
            book_name.setText(bundle.getString("book_name_ma"));
            reshte.setText(bundle.getString("reshte_ma"));
            enteshar.setText(bundle.getString("enteshar_ma"));
            upload.setText(bundle.getString("uplode_ma"));
            uni.setText(bundle.getString("daneshgah_ma"));
            ostad.setText(bundle.getString("ostad_name_ma"));
            book_price.setText(bundle.getString("book_price_ma"));
            tozihat.setText(bundle.getString("tozihat_ma"));
            img_avatar.setImageResource(bundle.getInt("image_avatar_ma"));
        }
    }
    public void onBackPressed(){
        adapter_menu_omumi.flag_omumi = false;
        adapter_menu_takhsosi.flag_takhasosi=false;
        adapter_menu_maqalat.flag_maqalat=false;
        super.onBackPressed();
    }

}