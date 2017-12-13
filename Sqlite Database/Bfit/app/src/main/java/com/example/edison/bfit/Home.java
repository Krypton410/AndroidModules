package com.example.edison.bfit;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Edison on 11/10/2017.
 */

public class Home extends AppCompatActivity {
    ImageButton login, register;
    Transition mFade;
    @Override
    protected void onCreate(Bundle s)
    {
        super.onCreate(s);
        setContentView(R.layout.home);
        getSupportActionBar().hide();
        login = (ImageButton) findViewById(R.id.log);
        register = (ImageButton) findViewById(R.id.reg);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, MainActivity.class);

                startActivity(i);

                finish();
            }
        });

    }
}
