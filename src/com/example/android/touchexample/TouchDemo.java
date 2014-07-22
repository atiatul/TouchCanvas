package com.example.android.touchexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TouchDemo extends View{

    private float mPosX;
    private float mPosY;
    private float mLastTouchX;
    private float mLastTouchY;

    public TouchDemo(Context context) {
        super(context, null, 0);
    }

    public TouchDemo(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public TouchDemo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(1);

        canvas.save();
        canvas.translate(mPosX, mPosY);
        canvas.drawCircle(50, 60, 30, paint);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastTouchX = event.getX();
                mLastTouchY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float x = event.getX();
                final float y = event.getY();
                final float dx = x - mLastTouchX;
                final float dy = y - mLastTouchY;
                mPosX += dx;
                mPosY += dy;
                mLastTouchX = x;
                mLastTouchY = y;
                invalidate();
                break;
        }
        return true;
    }
}
