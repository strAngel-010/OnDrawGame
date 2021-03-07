package com.example.ondrawgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements android.view.View.OnTouchListener {
    View myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        myView = new View(this, null, display.getWidth(), display.getHeight());
        setContentView(myView);
        myView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(android.view.View v, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int curX = myView.curX;
        int curY = myView.curY;
        int circleRadius = myView.circleRadius;
        if (curX-circleRadius <= x && x <= curX+circleRadius && curY-circleRadius <= y && y <= curY+circleRadius){
            myView.score++;
            myView.isTouched = true;
        } else {
            myView.maxScore = Math.max(myView.score, myView.maxScore);
            myView.score = 0;
        }
        return false;
    }
}