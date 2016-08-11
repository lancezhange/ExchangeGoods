package com.hackathon.exchange.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hackathon.exchange.AppConstants;
import com.hackathon.exchange.R;
import com.hackathon.exchange.adapter.TabFragmentAdapter;
import com.hackathon.exchange.fragment.HomeBaseFragment;
import com.hackathon.exchange.fragment.HomeFragment;
import com.hackathon.exchange.fragment.InformationFragment;
import com.hackathon.exchange.fragment.MyselfFragment;
import com.hackathon.exchange.fragment.PublishFragment;
import com.hackathon.exchange.fragment.TreasureFragment;
import com.hackathon.exchange.view.OnTabItemSelectListener;
import com.hackathon.exchange.view.PagerBottomTabLayout;
import com.hackathon.exchange.view.TabController;
import com.hackathon.exchange.view.TabViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabViewPager mViewPager;
    private PagerBottomTabLayout mPagerBottomTabLayout;
    int[] testColors = {0xFFff552e, 0xFF5B4947, 0xFF607D8B, 0xFFF57C00, 0xFFF57C00};
    TabController controller;
    ArrayList<Fragment> mFragments;
    private TabFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFragments = new ArrayList<>();
        mFragments.add( new HomeFragment());
        mFragments.add(new InformationFragment());
        mFragments.add(new MyselfFragment());
        mFragments.add(new PublishFragment());
        mFragments.add(new TreasureFragment());

        mViewPager = (TabViewPager) findViewById(R.id.id_tab_pager);
        mAdapter = new TabFragmentAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setScanScroll(false);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                AppConstants.HOME_PAGE_INDEX = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        initBottomTab();
    }

    private void initBottomTab() {
        mPagerBottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.id_tab_bar);
        //构建导航栏,得到Controller进行后续控制
        controller = mPagerBottomTabLayout.builder()
                .addTabItem(R.drawable.main_tab_record_icon, getString(R.string.tab_home), testColors[0])
                .addTabItem(R.drawable.main_tab_record_icon, getString(R.string.tab_treasure), testColors[0])
                .addTabItem(R.drawable.main_tab_record_icon, getString(R.string.tab_publish), testColors[0])
                .addTabItem(R.drawable.main_tab_calendar_icon, getString(R.string.tab_information), testColors[0])
                .addTabItem(R.drawable.main_tab_statistical_icon, getString(R.string.tab_myself), testColors[0])
                .build();
        mPagerBottomTabLayout.setBackgroundColor(getResources().getColor(R.color.common_bg));
        controller.addTabItemClickListener(listener);
    }

    OnTabItemSelectListener listener = new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag) {
            Log.i("asd", "onSelected:" + index + "   TAG: " + tag.toString());
            if (mViewPager != null && index < mViewPager.getAdapter().getCount()) {
                mViewPager.setCurrentItem(index, false);
                int counts = mFragments.size();
                HomeBaseFragment fragment;
                for (int i = 0; i < counts; i++) {
                    fragment = (HomeBaseFragment) mFragments.get(i);
                    if (index == i) {
                        fragment.OnFragmentSelectedChanged(true);
                    } else{
                        fragment.OnFragmentSelectedChanged(false);
                    }
                }
            }
        }

        @Override
        public void onRepeatClick(int index, Object tag) {
            Log.i("asd", "onRepeatClick:" + index + "   TAG: " + tag.toString());
        }
    };
}
