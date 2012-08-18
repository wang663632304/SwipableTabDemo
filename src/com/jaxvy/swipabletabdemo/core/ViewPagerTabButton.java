package com.jaxvy.swipabletabdemo.core;

import com.jaxvy.swipabletabdemo.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;

public class ViewPagerTabButton extends Button {
	
	private int lineColor = 0xFF006400;				//Color of the ViewPagerTabButton
	private int lineColorSelected = 0xFF006400;
	
	private int lineHeight = 2;
	private int lineHeightSelected = 6;
	
	public ViewPagerTabButton(Context context) {
		this(context, null);
	}
	
	public ViewPagerTabButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public ViewPagerTabButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		lineHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, lineHeight, context.getResources().getDisplayMetrics());
		lineHeightSelected = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, lineHeightSelected, context.getResources().getDisplayMetrics());
		
		final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ViewPagerExtensions, defStyle, 0);
		
		lineColor = a.getColor(R.styleable.ViewPagerExtensions_lineColor, lineColor);
		lineColorSelected = a.getColor(R.styleable.ViewPagerExtensions_lineColorSelected, lineColorSelected);
		
		lineHeight = a.getDimensionPixelSize(R.styleable.ViewPagerExtensions_lineHeight, lineHeight);
		lineHeightSelected = a.getDimensionPixelSize(R.styleable.ViewPagerExtensions_lineHeightSelected,
		    lineHeightSelected);
		
		a.recycle();
		
	}
	
	
	private Paint mLinePaint = new Paint();
	
	protected synchronized void onDraw(Canvas canvas) {
		
		super.onDraw(canvas);
		
		final Paint linePaint = mLinePaint;
		
		linePaint.setColor(isSelected() ? lineColorSelected : lineColor);
		
		final int height = isSelected() ? lineHeightSelected : lineHeight;
		
		// draw the line
		canvas.drawRect(0, getMeasuredHeight() - height, getMeasuredWidth(), getMeasuredHeight(), linePaint);
		
	}
	
	
	public void setLineColorSelected(int color) {
		this.lineColorSelected = color;
		invalidate();
	}
	
	public int getLineColorSelected() {
		return this.lineColorSelected;
	}
	
	public void setLineColor(int color) {
		this.lineColor = color;
		invalidate();
	}
	
	public int getLineColor() {
		return this.lineColor;
	}
	
	public void setLineHeight(int height) {
		this.lineHeight = height;
		invalidate();
	}
	
	public int getLineHeight() {
		return this.lineHeight;
	}
	
	public void setLineHeightSelected(int height) {
		this.lineHeightSelected = height;
		invalidate();
	}
	
	public int getLineHeightSelected() {
		return this.lineHeightSelected;
	}
	
}
