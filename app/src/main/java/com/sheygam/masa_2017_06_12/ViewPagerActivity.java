package com.sheygam.masa_2017_06_12;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager myPager;
    private MyAdapter adapter;
    private Button prevBtn, nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        myPager = findViewById(R.id.my_view_Pager);
        prevBtn = findViewById(R.id.prev_btn);
        nextBtn = findViewById(R.id.next_btn);
        adapter = new MyAdapter(getSupportFragmentManager());
        myPager.setAdapter(adapter);
        myPager.setOffscreenPageLimit(5);
        int currentFragment = myPager.getCurrentItem();
        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

        myPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d("ON_SCROLLED", "onPageScrolled() called with: position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
            }

            @Override
            public void onPageSelected(int position) {
//                Log.d("PAGE_SELECTED", "onPageSelected() called with: position = [" + position + "]");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        Log.d("STATE", "onPageScrollStateChanged: dragging");
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        Log.d("STATE", "onPageScrollStateChanged: settling");
                         break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        Log.d("STATE", "onPageScrollStateChanged: idle");
                             break;

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.prev_btn){
            int current = myPager.getCurrentItem();
            if(current>0){
                myPager.setCurrentItem(--current);
            }
        }else if(v.getId() == R.id.next_btn){
            myPager.setCurrentItem(5,false);
        }
    }

    class MyAdapter  extends FragmentStatePagerAdapter {
        private String[] titles = {"Page 1",
        "Page 2",
        "Page 3",
        "Page 4",
        "Page 5",
        "Page 6",
        "Page 7"};
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Random rnd = new Random();
            int color = Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
            return MyPage.newInctance(titles[position],color);
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }
}
