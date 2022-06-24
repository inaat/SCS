package com.scs.edu.pk.scs.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.scs.edu.pk.scs.Constant;
import com.scs.edu.pk.scs.R;
import com.scs.edu.pk.scs.databinding.ActivityHomeBinding;
import com.scs.edu.pk.scs.fragment.HomeFragment;
import com.scs.edu.pk.scs.fragment.NewsFragment;
import com.scs.edu.pk.scs.utils.Utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.BreakIterator;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {
    NavigationView navigationView;
    Context mContext;

    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    FrameLayout viewContainer;
    CircleImageView profile;
    BottomNavigationView bottomNavigation;
    //drawer Layout
    private TextView  nameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewContainer = findViewById(R.id.homeFragment);
        navigationView = (NavigationView) findViewById(R.id.navmenu);

        setUpDrawer();
        decorate();

        bottomNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        loadFragment(new HomeFragment());

                        return true;
                    case R.id.navigation_news:
                        loadFragment(new NewsFragment());

                        return true;
                }
                return false;
            }
        });
        loadFragment(new HomeFragment());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        Intent dashboard = new Intent(HomeActivity.this, HomeActivity.class);
                        overridePendingTransition(R.anim.slide_leftright,  R.anim.no_animation);
                        startActivity(dashboard);
                        break;

                    case R.id.menu_call:
                        Toast.makeText(getApplicationContext(), "Call Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_setting:
                        Toast.makeText(getApplicationContext(), "Setting Panel is Open", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.homeFragment, fragment);
        transaction.commit();
    }
    private void setUpDrawer() {
        //HEADER

        View headerLayout = navigationView.getHeaderView(0);
        nameTV = headerLayout.findViewById(R.id.drawer_userName);
        profile = headerLayout.findViewById(R.id.drawer_logo);

    }

    private void decorate() {
        //HEADER
//        nameTV.setText(Utils.getSharedPreferences(this, Constant.userName));
//        String imageUrl =Utils.getSharedPreferences(this, Constant.userImage);
//        Glide.with(getApplicationContext())
//                        .load(imageUrl)
//                        .placeholder(R.drawable.loading)
//                        .error(R.drawable.placeholder_user)
//                       .into(profile);



    }
    }
