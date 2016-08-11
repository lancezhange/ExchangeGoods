package com.hackathon.exchange.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.hackathon.exchange.R;
import com.hackathon.exchange.fragment.HomeFragment;
import com.hackathon.exchange.fragment.InformationFragment;
import com.hackathon.exchange.fragment.MyselfFragment;
import com.hackathon.exchange.fragment.PublishFragment;
import com.hackathon.exchange.fragment.TreasureFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /** 首页*/
    private LinearLayout tabHome;
    /** 宝贝*/
    private LinearLayout tabTreasure;
    /** 发布*/
    private LinearLayout tabPublish;
    /** 消息*/
    private LinearLayout tabInformation;
    /** 我的*/
    private LinearLayout tabMyself;
    private Fragment currentFragment;
    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    /**
     * 初始化View
     */
    private void initView() {
        tabHome = (LinearLayout) findViewById(R.id.home_tab);
        tabHome.setOnClickListener(this);
        tabTreasure = (LinearLayout) findViewById(R.id.treasure_tab);
        tabTreasure.setOnClickListener(this);
        tabPublish = (LinearLayout) findViewById(R.id.publish_tab);
        tabPublish.setOnClickListener(this);
        tabInformation = (LinearLayout) findViewById(R.id.information_tab);
        tabInformation.setOnClickListener(this);
        tabMyself = (LinearLayout) findViewById(R.id.myself_tab);
        tabMyself.setOnClickListener(this);

        fragmentList = new ArrayList<>();

        HomeFragment homeFragment = new HomeFragment();
        TreasureFragment treasureFragment = new TreasureFragment();
        PublishFragment publishFragment = new PublishFragment();
        InformationFragment informationFragment = new InformationFragment();
        MyselfFragment myselfFragment = new MyselfFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(informationFragment);
        fragmentList.add(myselfFragment);
        fragmentList.add(publishFragment);
        fragmentList.add(treasureFragment);

        currentFragment = fragmentList.get(0);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.home_tab:
                switchFragment(currentFragment, fragmentList.get(0));
                break;
            case R.id.treasure_tab:
                switchFragment(currentFragment, fragmentList.get(0));
                break;
            case R.id.publish_tab:
                switchFragment(currentFragment, fragmentList.get(0));
                break;
            case R.id.information_tab:
                switchFragment(currentFragment, fragmentList.get(0));
                break;
            case R.id.myself_tab:
                switchFragment(currentFragment, fragmentList.get(0));
                break;
        }

    }

    /**
     * 切换页面的重载，优化了fragment的切换
     */
    public void switchFragment(Fragment from, Fragment to) {
        if (from == null || to == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()/*.setCustomAnimations(R.anim.tran_pre_in,
                        R.anim.tran_pre_out)*/;
        if (!to.isAdded()) {
            // 隐藏当前的fragment，add下一个到Activity中
            transaction.hide(from).add(R.id.content_layout, to).commit();
        } else {
            // 隐藏当前的fragment，显示下一个
            transaction.hide(from).show(to).commit();
        }

        currentFragment = to;
    }


}
