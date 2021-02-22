package com.example.jozvefaal30;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jozvefaal30.model.SharedPreferencesManager;
import com.example.jozvefaal30.model.userApp;

public class login extends AppCompatActivity {
    /*controls SharedPreferencesManager class*/
    userApp user = new userApp();
    public String StoredValue;
    public boolean U, P;

    /*create object for xml*/
    EditText edtUName, edtuPass;
    TextView txtGoToSingUp;
    Button btnOkSingUp;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //for status bar page
        Window window = login.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(login.this, R.color.blue_back));

        /* Get object from xml file*/
        txtGoToSingUp = findViewById(R.id.go_to_sign_up);
        btnOkSingUp = findViewById(R.id.ok_login);
        edtUName = findViewById(R.id.login_user_name);
        edtuPass = findViewById(R.id.login_password);

        /*9.to get value Exit from method returnExit */
        StoredValue = returnExit();
        /*10.calling method to run mainActivity*/
        testNoFirst();

        /*12.go to sing up */
        txtGoToSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, slide_sign_up1.class));
                login.this.finish();
            }
        });

        /*13.check for go to  main activity*/
        btnOkSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(login.this);
                user = sharedPreferencesManager.get_shared_preferences();

                String uName = edtUName.getText().toString().trim();
                String uPass = edtuPass.getText().toString().trim();
                if (StoredValue != "exit") {
                    Toast.makeText(login.this, "لطفا ثبت نام کنید!", Toast.LENGTH_SHORT).show();
                }
                if (user.getFirst_time_run() == true) {
                    U = edt_name_Equle(uName);
                    P = edt_Pass_Equle(uPass);
                    if (U && P) {
                        Toast.makeText(login.this, "کاربر سیستم خوش آمدید ", Toast.LENGTH_SHORT).show();
                        SharedPreferences userDetails2 = getApplicationContext().getSharedPreferences("TITLE", MODE_PRIVATE);
                        SharedPreferences.Editor edit2 = userDetails2.edit();
                        edit2.putString("title", uName);
                        edit2.apply();
                        startActivity(new Intent(login.this, MainActivity.class));
                        login.this.finish();
                        delExit();
                        user.setFirst_time_run(false);
                        sharedPreferencesManager.set_false_first_time(user);
                    } else if (U) {
                        Toast.makeText(login.this, "رمز عبور نابرابر است...", Toast.LENGTH_SHORT).show();
                    } else if (P) {
                        Toast.makeText(login.this, "نام کاربری نابرابر است...", Toast.LENGTH_SHORT).show();
                    } else if (!P && !U) {
                        Toast.makeText(login.this, "نام کاربری و رمز عبور نابرابر است...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    /*1.method return value exit for Sign out of account */
    public String returnExit() {
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("Exit", MODE_PRIVATE);
        String val = myPrefs.getString("exit", null);
        return val;
    }

    /*2.method to check first Run or more than one*/
    public void testNoFirst() {
        final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(login.this);
        user = sharedPreferencesManager.get_shared_preferences();

        if (user.getFirst_time_run() == false) {
            startActivity(new Intent(login.this, MainActivity.class));
            login.this.finish();
        }
    }

    /*3.method delete exit value from SharedPreferences*/
    public void delExit() {
        SharedPreferences userDetails = getApplicationContext().getSharedPreferences("Exit", MODE_PRIVATE);
        SharedPreferences.Editor edit = userDetails.edit();
        edit.remove("exit");
        edit.commit();
    }

    /*4.mehod return user name saved*/
    public String getUname(String name) {
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("User", MODE_PRIVATE);
        String storedValue = myPrefs.getString(name, null);
        return storedValue;
    }

    /*5.method return user pass saved*/
    public String getUPass(String pass) {
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("User", MODE_PRIVATE);
        String storedValue = myPrefs.getString(pass, null);
        return storedValue;
    }

    /*6.method Equle name user is write and user name saved in system*/
    public Boolean edt_name_Equle(String name) {
        boolean b = false;
        String store = getUname(name);
        if (store == null) {
        } else {
            String uName = edtUName.getText().toString().trim();
            b = store.equals(uName);
        }
        return b;
    }

    /*7.method Equle pass user is write and user password saved in system*/
    public Boolean edt_Pass_Equle(String pass) {
        boolean b = false;
        String store = getUPass(pass);
        if (store == null) {
        } else {
            String uPass = edtuPass.getText().toString().trim();
            b = store.equals(uPass);
        }
        return b;
    }

}
