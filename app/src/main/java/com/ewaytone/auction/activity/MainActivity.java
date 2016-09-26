package com.ewaytone.auction.activity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.ewaytone.auction.R;
import com.ewaytone.auction.bean.Tab;
import com.ewaytone.auction.fragment.AuctionFragment;
import com.ewaytone.auction.fragment.CategoryFragment;
import com.ewaytone.auction.fragment.HomeFragment;
import com.ewaytone.auction.fragment.MineFragment;
import com.ewaytone.auction.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private FragmentTabHost mTabhost;
    private LayoutInflater mInflater;

    private List<Tab> mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInflater = LayoutInflater.from(this);
        initTabs();
    }

    /**初始化底部选项卡菜单**/
    private void initTabs() {

        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        //为fragmenttabhost设置盛装容器
        mTabhost.setup(this,getSupportFragmentManager(), R.id.realtabcontent);

        mTabs = new ArrayList<>(4);

        Tab tabHome = new Tab(R.string.home,R.drawable.selector_icon_home, HomeFragment.class);
        Tab tabCategory = new Tab(R.string.category,R.drawable.selector_icon_category, CategoryFragment.class);
        Tab tabAuction = new Tab(R.string.auction, R.drawable.selector_icon_auction, AuctionFragment.class);
        Tab tabMine = new Tab(R.string.mine,R.drawable.selector_icon_mine, MineFragment.class);

        mTabs.add(tabHome);
        mTabs.add(tabCategory);
        mTabs.add(tabAuction);
        mTabs.add(tabMine);

        for (Tab tab : mTabs) {

            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabhost.addTab(tabSpec, tab.getFragment(),null);
        }


        //设置是否显示分割线
        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
    }


    /**建立每个选项卡的视图**/
    private View buildIndicator(Tab tab) {

        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.img_tab);
        TextView txt = (TextView) view.findViewById(R.id.txt_tab);

        img.setBackgroundResource(tab.getIcon());
        txt.setText(tab.getTitle());

        return view;
    }
}
