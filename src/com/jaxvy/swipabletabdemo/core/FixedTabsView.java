package com.jaxvy.swipabletabdemo.core;

import java.util.ArrayList;

import com.jaxvy.swipabletabdemo.R;
import com.jaxvy.swipabletabdemo.adapter.FixedTabsAdapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FixedTabsView extends LinearLayout implements ViewPager.OnPageChangeListener {
	
	private Context context;
	
	private ViewPager viewPager;
	
	private FixedTabsAdapter fixedTabsAdapter;
	
	private ArrayList<View> tabList = new ArrayList<View>();
	
	private Drawable dividerDrawable;
	
	private int dividerColor = 0xFF636363;
	private int dividerMarginTop = 12;
	private int dividerMarginBottom = 21;
	
	public FixedTabsView(Context context) {
		this(context, null);
	}
	
	public FixedTabsView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public FixedTabsView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);
		
		this.context = context;
		
		final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ViewPagerExtensions, defStyle, 0);
		
		dividerColor = a.getColor(R.styleable.ViewPagerExtensions_dividerColor, dividerColor);
		
		dividerMarginTop = a.getDimensionPixelSize(R.styleable.ViewPagerExtensions_dividerMarginTop, dividerMarginTop);
		dividerMarginBottom = a.getDimensionPixelSize(R.styleable.ViewPagerExtensions_dividerMarginBottom,
		    dividerMarginBottom);
		
		dividerDrawable = a.getDrawable(R.styleable.ViewPagerExtensions_dividerDrawable);
		
		a.recycle();
		
		this.setOrientation(LinearLayout.HORIZONTAL);
	}
	
	
	public void setAdapter(FixedTabsAdapter adapter) {
		this.fixedTabsAdapter = adapter;
		
		if (viewPager != null && fixedTabsAdapter != null) initTabs();
	}
	
	
	public void setViewPager(ViewPager pager) {
		this.viewPager = pager;
		viewPager.setOnPageChangeListener(this);
		
		if (viewPager != null && fixedTabsAdapter != null) initTabs();
	}
	
	/**
	 * Initialize and add all tabs to the layout
	 */
	private void initTabs() {
		
		removeAllViews();
		tabList.clear();
		
		if (fixedTabsAdapter == null) return;
		
		for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
			
			final int index = i;
			
			View tab = fixedTabsAdapter.getView(i);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
			tab.setLayoutParams(params);
			this.addView(tab);
			
			tabList.add(tab);
			
			if (i != viewPager.getAdapter().getCount() - 1) {
				this.addView(getSeparator());
			}
			
			tab.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					viewPager.setCurrentItem(index);
				}
			});
			
		}
		
		selectTab(viewPager.getCurrentItem());
	}
	
	@Override
	public void onPageScrollStateChanged(int state) {}
	
	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
	
	@Override
	public void onPageSelected(int position) {
		selectTab(position);
	}
	
	
	/**
	 * Creates and returns a new Separator View
	 * 
	 * @return
	 */
	private View getSeparator() {
		View v = new View(context);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1, LayoutParams.FILL_PARENT);
		params.setMargins(0, dividerMarginTop, 0, dividerMarginBottom);
		v.setLayoutParams(params);
		
		if (dividerDrawable != null) v.setBackgroundDrawable(dividerDrawable);
		else v.setBackgroundColor(dividerColor);
		
		return v;
	}
	
	
	/**
	 * Runs through all tabs and sets if they are currently selected.
	 * 
	 * @param position
	 *          The position of the currently selected tab.
	 */
	private void selectTab(int position) {
		
		for (int i = 0, pos = 0; i < getChildCount(); i++) {
			
			if (this.getChildAt(i) instanceof ViewPagerTabButton) {
				this.getChildAt(i).setSelected(pos == position);
				pos++;
			}
			
		}
	}
	
}
