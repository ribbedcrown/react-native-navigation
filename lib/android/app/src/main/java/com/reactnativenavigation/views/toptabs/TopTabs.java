package com.reactnativenavigation.views.toptabs;

import android.content.Context;
import android.graphics.Typeface;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;

import com.reactnativenavigation.parse.params.Colour;
import com.reactnativenavigation.parse.params.Number;
import com.reactnativenavigation.utils.ViewUtils;
import com.reactnativenavigation.views.topbar.TopBar;

public class TopTabs extends TabLayout {
    private final TopTabsStyleHelper styleHelper;

    public TopTabs(Context context) {
        super(context);
        styleHelper = new TopTabsStyleHelper(this);
    }

    public void setFontFamily(int tabIndex, Typeface fontFamily) {
        styleHelper.setFontFamily(tabIndex, fontFamily);
    }

    public int[] getSelectedTabColors() {
        return SELECTED_STATE_SET;
    }

    public int[] getDefaultTabColors() {
        return EMPTY_STATE_SET;
    }

    public void applyTopTabsColors(Colour selectedTabColor, Colour unselectedTabColor) {
        styleHelper.applyTopTabsColors(selectedTabColor, unselectedTabColor);
    }

    public void applyTopTabsFontSize(Number fontSize) {
        styleHelper.applyTopTabsFontSize(fontSize);
    }

    public void setTopTabsRippleColor(Colour rippleColor) {
        styleHelper.setTopTabsRippleColor(rippleColor);
    }

    public void setTopTabsIndicator(int height, Colour indicatorColor) {
        styleHelper.setTopTabsIndicator(height, indicatorColor);
    }

    public int isVisible() {
        return getVisibility();
    }

    public void setVisibility(TopBar topBar, boolean visible) {
        if (visible && getTabCount() > 0) {
            if (getParent() == null) {
                topBar.addView(this, 1);
            }
            setVisibility(VISIBLE);
        } else {
            setVisibility(GONE);
        }
    }

    public void clear() {
        setupWithViewPager(null);
        ViewUtils.removeFromParent(this);
    }

    public void init(ViewPager viewPager) {
        setupWithViewPager(viewPager);
    }
}
