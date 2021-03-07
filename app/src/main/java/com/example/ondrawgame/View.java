package com.example.ondrawgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;

import java.sql.Time;
import java.util.Random;

public class View extends android.view.View {
    final int width;
    final int height;
    int score = 0;
    int maxScore = 0;
    int curX, curY;
    int circleRadius = 60;
    boolean isTouched;
    int counter = 0;

    public View(Context context, @Nullable AttributeSet attrs, int width, int height) {
        super(context, attrs);
        this.width = width-150;
        this.height = height-300;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pc = new Paint();
        Paint pt = new Paint();
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        if (counter == 0 || counter == 50){
            if (!isTouched){
                maxScore = Math.max(score, maxScore);
                score = 0;
            }
            curX = random.nextInt(width-circleRadius)+circleRadius;
            curY = random.nextInt(height-(circleRadius+90))+circleRadius+90;
            counter = 1;
            isTouched = false;
        }

        pc.setColor(Color.RED);
        pc.setStyle(Paint.Style.FILL);
        pt.setColor(Color.BLACK);
        pt.setTextSize(50);

        canvas.drawText("Score: "+score, 25, 90, pt);
        canvas.drawText("Max score: "+maxScore, 325, 90, pt);
        canvas.drawCircle(curX, curY, circleRadius, pc);
        counter++;
        this.invalidate();
    }
}
