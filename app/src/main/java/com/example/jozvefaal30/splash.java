package com.example.jozvefaal30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.jozvefaal30.model.SharedPreferencesManager;
import com.example.jozvefaal30.model.userApp;

public class splash extends AppCompatActivity {
    userApp user = new userApp();
    public String StoredValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StoredValue = returnExit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(splash.this);
                user = sharedPreferencesManager.get_shared_preferences();

                if (user.getFirst_time_run() == true || StoredValue =="exit") {
                    Intent i = new Intent(splash.this, login.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(splash.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }, 1000);
    }


    public String returnExit(){
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("Exit", MODE_PRIVATE);
        String val = myPrefs.getString("exit", null);
        return val;
    }
}
