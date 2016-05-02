package com.adorkable.acientdict.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.ui.fragment.DictFragment;
import com.adorkable.acientdict.ui.fragment.DiscoverFragment;
import com.adorkable.acientdict.ui.fragment.ProfileFragment;
import com.adorkable.acientdict.ui.fragment.TranslateFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private List<Fragment> mFragmentList;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }


    private void initView() {
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);

    }

    private void initData() {

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mFragmentList = new ArrayList<>();

        mFragmentList.add(new DictFragment());
        mFragmentList.add(new TranslateFragment());
        mFragmentList.add(new DiscoverFragment());
        mFragmentList.add(new ProfileFragment());

        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mSectionsPagerAdapter);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentList.get(position).toString();
        }
    }
}
