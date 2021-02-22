package com.example.jozvefaal30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class slide_sign_up2 extends AppCompatActivity {
    Button button_sign_up_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_sign_up2);
        button_sign_up_ok=findViewById(R.id.btn_sign_up_ok);
        button_sign_up_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(slide_sign_up2.this,signup.class));
                slide_sign_up2.this.finish();
            }
        });
    }

}