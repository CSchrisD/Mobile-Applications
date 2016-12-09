package com.example.christinaduran.drain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AnimationUtils;

//import java.util.logging.Handler;

public class Screen extends View {
    public Tomato tom = new Tomato();
    private Paint paint = new Paint();
    double accelx;
    double accely;
    int widthX;
    int heightY;
    public Runnable animator = new Runnable() {
        @Override
        public void run() {
            double bounce = 0.7;
            //boolean needNewFrame = false;
            long now = AnimationUtils.currentAnimationTimeMillis();

            //prevent tomato from going over walls, only around
            //and add a little bounce when hitting a wall (its kind of ugly though)

            //don't go through walls for first four ifs
            if(tom.y-tom.rad< 0){
                tom.y = tom.rad;
                accely = accely*(-3);
            }
            if(tom.x+tom.rad > widthX){
                tom.x = widthX - tom.rad;
                accelx = accelx*(-3);
            }
            if(tom.x-tom.rad<0){
                tom.x = tom.rad;
                accelx = accelx*(-3);
            }
            if(tom.y+tom.rad> heightY){
                tom.y = heightY-tom.rad;
                accely = accely*(-3);
            }
            //don't pass through the two walls
            if(tom.y+tom.rad > (heightY/2) - 200 && tom.y-tom.rad < (heightY/2) - 200 && tom.x-tom.rad < widthX/2+200){
                tom.y = ((heightY/2)-200) - tom.rad;
                accely = accely*(-3);
            }
            if(tom.y-tom.rad < (heightY/2) - 193 && tom.y+tom.rad > (heightY/2)-200 && tom.x-tom.rad < widthX/2+200){
                tom.y = ((heightY/2)-193) + tom.rad;
                accely = accely*(-3);
            }
            if(tom.y+tom.rad > heightY/2+200 && tom.y-tom.rad < heightY/2+200 && tom.x+tom.rad > widthX/2-200){
                tom.y = heightY/2+200 - tom.rad;
                accely = accely*(-3);
            }
            if(tom.y-tom.rad < heightY/2+210 && tom.y+tom.rad > heightY/2+200 && tom.x+tom.rad > widthX/2-200){
                tom.y = heightY/2+210 + tom.rad;
                accely = accely*(-3);
            }

            tom.x += accelx*bounce;
            tom.y += accely*bounce;

            //if the tomato hits the drain the tomato is placed at its
            //original position at the top again
            double diffx = tom.x - (widthX/2);
            double diffy = tom.y - (heightY-100);
            double difftotal = Math.sqrt(diffx*diffx + diffy*diffy);
            if(difftotal < tom.rad+20){
                tom.x = 0;
                tom.y = 0;
            }

                postDelayed(this, 20);
            invalidate();
        }
    };

    public Screen(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //paint for walls, tomato, drain, background
        widthX = canvas.getWidth();
        heightY = canvas.getHeight();
        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, widthX, heightY, paint);
        //draw drain
        paint.setColor(Color.DKGRAY);
        canvas.drawCircle(widthX/2,heightY-100,50,paint);
        paint.setStrokeWidth(20);
        //top middle line
        canvas.drawLine(0,heightY/2 - 200,widthX/2+200,heightY/2 - 200,paint);
        //bottom middle line
        canvas.drawLine(widthX/2-200,heightY/2+200,widthX,heightY/2+200,paint);
        //draw tomato
        paint.setColor(Color.RED);
        canvas.drawCircle(tom.x,tom.y,tom.rad,paint);
    }
}
