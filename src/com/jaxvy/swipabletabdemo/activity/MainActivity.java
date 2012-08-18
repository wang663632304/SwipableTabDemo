package com.jaxvy.swipabletabdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.jaxvy.swipabletabdemo.R;
import com.jaxvy.swipabletabdemo.adapter.FixedTabsAdapter;
import com.jaxvy.swipabletabdemo.adapter.SwipePagerAdapter;
import com.jaxvy.swipabletabdemo.core.FixedTabsView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_activity_screen);
		
		
		FixedTabsView fixedTabsView = (FixedTabsView) findViewById(R.id.fixed_tabs);	//Contains the tabs view
		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);						//Contains the content
		
		//Initialize a SwipePagerAdapter
		PagerAdapter swipePagerAdapter = new SwipePagerAdapter(this);		
		
		//Assign the SwipePagerAdapter to the viewPager so that is supports swiping
		viewPager.setAdapter(swipePagerAdapter);
		viewPager.setCurrentItem(1);
		viewPager.setPageMargin(1);	
		
		//Initialize a FixedTabsAdapter
		FixedTabsAdapter fixedTabsAdapter = new FixedTabsAdapter(this);
		
		//Assign the FixedTabsView a FixedTabsAdapter and SwipePagerAdapter
		fixedTabsView.setAdapter(fixedTabsAdapter);
		fixedTabsView.setViewPager(viewPager);
	}
}
