package com.hackathon.exchange.view;

import android.content.Context;

/**
 * 开放的导航按钮构建入口
 */
public class TabItemBuilder
{
    private TabItem mTabItem;

    private Context mContext;

    public TabItemBuilder(Context context){
        mContext = context;
    }

    public TabItemBuild create()
    {
        mTabItem = new TabItem(mContext);
        return mTabItem.builder(this);
    }

    protected TabItem getTabItem()
    {
        return mTabItem;
    }
}
