package com.kelz.crowded.crowded.ui.base;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.kelz.crowded.crowded.R;
import com.kelz.crowded.crowded.common.CrowdedConstants;
import com.kelz.crowded.crowded.ui.base.search.SearchFragment;
import com.kelz.crowded.crowded.ui.base.ViewPagerAdapter;
import com.kelz.crowded.crowded.ui.base.share.ShareFragment;

public class MainActivity
        extends AppCompatActivity
        implements SearchFragment.OnFragmentInteractionListener,
        ShareFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.pager);
        setUpViewPager(viewPager);

        tabLayout = findViewById(R.id.mainTabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(SearchFragment.newInstance(), CrowdedConstants.Navigation.SEARCH);
        viewPagerAdapter.addFragment(ShareFragment.newInstance(), CrowdedConstants.Navigation.SHARE);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
