package com.example.jozvefaal30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jozvefaal30.adapter.viewPagerAdapter;
import com.example.jozvefaal30.model.ChosoeTabs;
import com.example.jozvefaal30.model.SharedPreferencesManager;
import com.example.jozvefaal30.model.userApp;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout myDraw;
    ViewPager viewPager;
    TabLayout tabLayout;
    TextView userName,support,about,exit;
    ImageView imgMenu, search,imageView;
    public String IMG;
    public static boolean flag_omumi, flag_takhasosi, flag_maqalat = false;
    public static String Transaction_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Get object from xml file*/
        search = findViewById(R.id.img_search);
        imageView=findViewById(R.id.img_user);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        imgMenu=findViewById(R.id.img_menu);
        support=findViewById(R.id.support);
        about=findViewById(R.id.about);
        exit=findViewById(R.id.exit);
        myDraw = findViewById(R.id.myDraw);
        userName = findViewById(R.id.user_name_menu);
        /*2.set to show UserName*/
        SharedPreferences myPrefs;
        myPrefs = getSharedPreferences("TITLE", MODE_PRIVATE);
        String StoredValue = myPrefs.getString("title", null);
        userName.setText(StoredValue);





        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.jozvefaal30.support.class));
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.jozvefaal30.about.class));
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog();
                    }
                });
                myDraw.closeDrawers();
            }

            public void alertDialog() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false).setMessage(" خروج از حساب کاربری ؟ ")
                        .setPositiveButton(
                                " بله ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String exit = "exit";
                                        SharedPreferences userDetails = getApplicationContext().getSharedPreferences("Exit", MODE_PRIVATE);
                                        SharedPreferences.Editor edit = userDetails.edit();
                                        edit.putString("exit", exit);
                                        edit.apply();
                                        finish();
                                        userApp user = new userApp();
                                        final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(MainActivity.this);
                                        user = sharedPreferencesManager.get_shared_preferences();
                                        user.setFirst_time_run(true);
                                        sharedPreferencesManager.set_false_first_time(user);

                                    }
                                }
                        )
                        .setNeutralButton("خیر", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog _alert = builder.create();

                _alert.setIcon(R.drawable.ic_exit_icon);
                _alert.show();
            }
        });
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDraw.openDrawer(Gravity.RIGHT);

            }
        });

        //=======for TAB 1============
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFrg(new omumi(), "عمومی");
        adapter.addFrg(new takhasosi(), "تخصصی");
        adapter.addFrg(new maqalat(), "مقالات");
        viewPager.setAdapter(adapter);
        if (tabLayout.getSelectedTabPosition() == 0) {
            Transaction_type = ChosoeTabs.getChooseTab_omumi();
        } else if (tabLayout.getSelectedTabPosition() == 2) {
            Transaction_type = ChosoeTabs.getChooseTab_takhasosi();
        } else if (tabLayout.getSelectedTabPosition() == 1) {
            Transaction_type = ChosoeTabs.getChooseTab_maqalat();
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(R.color.transparent);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        //========for TAB==========

    }

    //====set TAB 2======
    public void setTab() {
        if (flag_omumi) {
            viewPager.setCurrentItem(0);
            flag_omumi = false;
            flag_takhasosi = false;
            flag_maqalat = false;

        }
        if (flag_takhasosi) {
            viewPager.setCurrentItem(2);
            flag_omumi = false;
            flag_takhasosi = false;
            flag_maqalat = false;
        }
        if (flag_maqalat) {
            viewPager.setCurrentItem(3);
            flag_omumi = false;
            flag_takhasosi = false;
            flag_maqalat = false;
        }

    }
    /*10.when you back from search this method is calling*/
    @Override
    protected void onResume() {
        super.onResume();
        setTab();

    }
}