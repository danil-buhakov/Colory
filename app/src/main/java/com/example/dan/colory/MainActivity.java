package com.example.dan.colory;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends Activity {


    private Button btnChangeColor;
    private ConstraintLayout clBackground;
    private ImageView imgGrad;
    public static int r,g,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        btnChangeColor = (Button) findViewById(R.id.btnChangeColor);
        clBackground = (ConstraintLayout) findViewById(R.id.clBackground);
        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor();
            }
        });


        setColor();


    }

    private void setColor(){
        RandomColor();
        clBackground.setBackgroundColor(Color.argb(255,r,g,b));
    }

    private void RandomColor(){
        r=new Random().nextInt(256)-1;
        g=new Random().nextInt(256)-1;
        b=new Random().nextInt(256)-1;
    }


}
