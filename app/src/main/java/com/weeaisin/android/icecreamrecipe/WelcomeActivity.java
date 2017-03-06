package com.weeaisin.android.icecreamrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by AiLeng on 26-Feb-17.
 */

public class WelcomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        ImageView img = (ImageView)findViewById(R.id.imageView3);
        Animation animation = AnimationUtils.loadAnimation(getApplication(), R.anim.animation);
        img.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Toast toast = Toast.makeText(this, "WELCOME TO SWEET TOOTH!", Toast.LENGTH_SHORT);
        toast.show();

    }
}
