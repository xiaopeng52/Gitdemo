package com.example.day05_zdyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * date:2018/5/11
 * author:易宸锋(dell)
 * function:
 * 1.你学会怎么去定义咱们的这个自绘式自定义,集成View
 * 2.覆写其构造方法,固定模式
 * 3.onMeasuer:,onLayout:OnDraw:
 * 4.关键的方法,setMeasuredDimension,//设置抗锯齿 mPaint.setAntiAlias(true);
 */
/**
 * 自绘式的自定义控件,继承VIew
 * onMeasuer:
 * onLayout:
 * OnDraw:
 */
public class MyView extends View {

	//这三个方法是让你做初始化的业务
	//代码中创建控件对象,自动回调此方法
	public MyView(Context context) {
		this(context,null);
	}

	//XML布局中使用此自定义控件,自动回调此方法
	public MyView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	//XML布局中使用该控件,且带有样式时,自动回调
	public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		intiView();
	}

	private Paint mPaint;
	//做控件的初始化
	private void intiView() {
		System.out.print("我是控件初始化的逻辑");
		mPaint = new Paint();
	}

	//测量宽高（确定宽高）,控件在显示时,自动调用该方法
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
//                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
		
		//传入这个方法的参数就是控件的最终宽高
		setMeasuredDimension(300, 200);
	}
	
	//分配控件在父控件的位置,一般我们不动该方法
	//left、top、right、bottom是父空间传入的参数，这四个参数表明了组件的位置侧面显示了宽高
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
		System.out.println(left + " ; " + top + " ; " + right + " ; " + bottom);
	}
	
	//在组件中绘制内容
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.RED);
		mPaint.setColor(Color.YELLOW);
		//设置抗锯齿
		mPaint.setAntiAlias(true);
		//设置圆心坐标和圆的半径
		canvas.drawCircle(100, 100, 60, mPaint);
	}
}
