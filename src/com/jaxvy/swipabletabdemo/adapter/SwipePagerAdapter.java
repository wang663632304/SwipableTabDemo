package com.jaxvy.swipabletabdemo.adapter;

import com.jaxvy.swipabletabdemo.R;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
public class SwipePagerAdapter extends PagerAdapter {
	
	protected transient Activity mContext;
	
	private int mLength = 3;	//Set the number of tabs
		
	public SwipePagerAdapter(Activity context) {
		mContext = context;
	}
	
	@Override
	public int getCount() {
		return mLength;
	}
	
	@Override
	public Object instantiateItem(View container, int position) {
				
		RelativeLayout relativeLayout = new RelativeLayout(mContext);
		
		//Inflate appropriate tab content in the ViewPager (the container) according to the tab position
		
		if( position == 0){
			mContext.getLayoutInflater().inflate(R.layout.swipabletab_content_1, relativeLayout);
		}
		else if( position == 1){
			mContext.getLayoutInflater().inflate(R.layout.swipabletab_content_2, relativeLayout);
		}
		else{
			mContext.getLayoutInflater().inflate(R.layout.swipabletab_content_3, relativeLayout);
		}
		
		((ViewPager) container).addView(relativeLayout, 0);
		
		return relativeLayout;
	}
	
	
	@Override
	public void destroyItem(View container, int position, Object view) {
		((ViewPager) container).removeView((View) view);
	}
	
	
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((View) object);
	}
	
	
	@Override
	public void finishUpdate(View container) {}
	
	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {}
	
	@Override
	public Parcelable saveState() {
		return null;
	}
	
	@Override
	public void startUpdate(View container) {}
	
}
