package com.ewaytone.auction.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ewaytone.auction.R;

/**
 * Created by xhz on 2016/9/22.
 */

public class HomeFragment extends BaseFragment{
    private Toolbar mToolBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mToolBar = (Toolbar) view.findViewById(R.id.toolbar);
        mToolBar.inflateMenu(R.menu.toolbar_menu);
        mToolBar.setTitle("cc");

        return view;
    }
}
