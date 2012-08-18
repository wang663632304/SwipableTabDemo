package com.jaxvy.swipabletabdemo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import com.jaxvy.swipabletabdemo.R;
import com.jaxvy.swipabletabdemo.core.ViewPagerTabButton;

public class FixedTabsAdapter {

	private Activity mContext;

	private String[] mTitles = { "Tab 1", "Tab 2", "Tab 3" };

	public FixedTabsAdapter(Activity ctx) {
		this.mContext = ctx;
	}

	public View getView(int position) {
		ViewPagerTabButton tab;

		LayoutInflater inflater = mContext.getLayoutInflater();
		tab = (ViewPagerTabButton) inflater.inflate(R.layout.swipable_tab_button_layout, null);

		if (position < mTitles.length)
			tab.setText(mTitles[position]);

		return tab;
	}

}
