package com.example.day05_6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 肖彭 on 2018/5/14.
 */

public class ballsView extends View {

    private Paint paint;
    private  int X1=100;
    private  int Y1=100;
    private int mHeight;
    private int mWidth;
    private boolean mOnBall;

    public ballsView(Context context) {
        this(context,null);
    }

    public ballsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ballsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview();
    }

    private void initview() {
//创建画笔
        paint = new Paint();

        Canvas canvas= new Canvas();




    }


    //测试
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(500,500);
        //        获取当前控件的宽和高
        mHeight = this.getHeight();
        mWidth = this.getWidth();
        //获取屏幕的正中心点
//        X = mWidth / 2;
//        Y = mHeight / 2;
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.GREEN);
//画布
        canvas.drawColor(Color.RED);
        //PAint的颜色
        paint.setColor(Color.BLUE);
        //paint抗锯齿
        paint.setAntiAlias(true);
        //设置位置   半径
        canvas.drawCircle(X1,Y1,60,paint);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        X1 = (int) event.getX();
        Y1 = (int) event.getY();

        //这个很重要，关系到小圆点能否滑动,刷新

        invalidate();

        return true;




    }
}
