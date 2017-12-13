package com.example.edison.bfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Edison on 11/10/2017.
 */

public class Viewer extends AppCompatActivity{
    TextView t;
    @Override
    protected void onCreate(Bundle saved){
        super.onCreate(saved);
        t = (TextView) findViewById(R.id.textView);

        //t.setText()
    }
}
