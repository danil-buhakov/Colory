package com.example.dan.colory;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {


    private ConstraintLayout clBackground;
    private TextView txtRed, txtGreen, txtBlue;
    private StarView sv;
    private int r,g,b;
    private int r_cur,g_cur,b_cur;
    private int step=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        clBackground = (ConstraintLayout) findViewById(R.id.clBackground);
        txtRed = (TextView) findViewById(R.id.txtRed);
        txtGreen = (TextView) findViewById(R.id.txtGreen);
        txtBlue = (TextView) findViewById(R.id.txtBlue);
        sv=(StarView) findViewById(R.id.svMain);

        View.OnTouchListener touchListener = new View.OnTouchListener() {
            private float y_was;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        y_was=motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if(y_was>motionEvent.getY()){
                            moveUp(view);
                            y_was=motionEvent.getY();
                        }
                        else if(y_was<motionEvent.getY()){
                            moveDn(view);
                            y_was=motionEvent.getY();
                        }
                        break;
                }

                return true;
            }
        };
        txtRed.setOnTouchListener(touchListener);
        txtBlue.setOnTouchListener(touchListener);
        txtGreen.setOnTouchListener(touchListener);
        setColor();


    }

    private void moveUp(View view){
        if(findViewById(view.getId())==txtRed){
            Log.d("move",Integer.toString(r_cur));
            if(255-r_cur>=step)
                r_cur+=step;
        }
        if(findViewById(view.getId())==txtGreen){
            Log.d("move",Integer.toString(g_cur));
            if(255-g_cur>=step)
                g_cur+=step;
        }
        if(findViewById(view.getId())==txtBlue){
            Log.d("move",Integer.toString(b_cur));
            if(255-b_cur>=step)
                b_cur+=step;
        }
        setStarColor();
    }

    private void moveDn(View view){
        if(findViewById(view.getId())==txtRed){
            Log.d("move",Integer.toString(r_cur));
            if(r_cur-step>=0)
                r_cur-=step;
        }
        if(findViewById(view.getId())==txtGreen){
            Log.d("move",Integer.toString(g_cur));
            if(g_cur-step>=0)
                g_cur-=step;
        }
        if(findViewById(view.getId())==txtBlue){
            Log.d("move",Integer.toString(b_cur));
            if(b_cur-step>=0)
                b_cur-=step;
        }
        setStarColor();
    }

    private void setStarColor(){
        sv.setColor(Color.argb(255,r_cur,g_cur,b_cur));
        sv.invalidate();
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
