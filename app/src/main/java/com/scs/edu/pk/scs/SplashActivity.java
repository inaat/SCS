package com.scs.edu.pk.scs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.scs.edu.pk.scs.login.LoginActivity;
import com.scs.edu.pk.scs.model.Login;
import com.scs.edu.pk.scs.teacher.HomeActivity;
import com.scs.edu.pk.scs.utils.Utils;

public class SplashActivity extends AppCompatActivity {
    //variable

    Animation topAnim,bottomAnim,leftAnim;
    ImageView splashLogoImage,splashPencilImage;
    TextView splashWelcomeText;
    public static int splashTimeOut = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.hide();
        Window window = getWindow() ;


        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        leftAnim = AnimationUtils.loadAnimation(this,R.anim.left_animation);

        splashLogoImage =findViewById(R.id.splash_logo_image);
        splashPencilImage =findViewById(R.id.splash_pencil_image);
        splashWelcomeText =findViewById(R.id.splash_wellcome_text);
        splashLogoImage.setAnimation(topAnim);
        splashPencilImage.setAnimation(bottomAnim);
        splashWelcomeText.setAnimation(leftAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splash();
            }
        },splashTimeOut );
    }
    private void splash() {

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Boolean isLoggegIn;
                Boolean isUrlTaken;

                try {
                    isLoggegIn = Utils.getSharedPreferencesBoolean(getApplicationContext(), Constant.IsLoggingIn);
                } catch (NullPointerException NPE) {
                    isLoggegIn = false;
                }

                Log.e("loggeg", isLoggegIn.toString());



                    if(isLoggegIn){
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                        finish();
                    }else {
                        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);
                        finish();
                    }
                }

        }, splashTimeOut);
    }
}