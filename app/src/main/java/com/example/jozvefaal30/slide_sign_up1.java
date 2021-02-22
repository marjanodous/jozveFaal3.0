package com.example.jozvefaal30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class slide_sign_up1 extends AppCompatActivity {
LinearLayout lnr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_sign_up1);
        lnr=findViewById(R.id.signup1);
        lnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(slide_sign_up1.this,slide_sign_up2.class));
                slide_sign_up1.this.finish();
            }
        });
    }

}