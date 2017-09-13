package com.example.qthjen.viewpagerdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public static class PlaceholderFragment extends Fragment {

        public static final String KEY_COLOR = "key_color";

        public PlaceholderFragment() {}

        /** Method static dạng singleton(design partern) cho phép tạo ra fragment mới lấy tham số đầu vào
         * cài đặt màu sắc **/
        public static PlaceholderFragment newInstance(int color) {

            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(KEY_COLOR, color);
            fragment.setArguments(args);

            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.fragment);

            TextView tv = (TextView) rootView.findViewById(R.id.tv);

            switch (getArguments().getInt(KEY_COLOR)) {

                case 0:relativeLayout.setBackgroundColor(Color.CYAN);
                    tv.setText("Q.Thjen Cyan");break;

                case 1:relativeLayout.setBackgroundColor(Color.YELLOW);
                    tv.setText("Q.Thjen Yellow");break;

                case 2:relativeLayout.setBackgroundColor(Color.BLUE);
                    tv.setText("Q.Thjen Blue");break;

                case 3:relativeLayout.setBackgroundColor(Color.GRAY);
                    tv.setText("Q.Thjen Gray");break;

            }

            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {

                case 0:return "Page 1";
                case 1:return "Page 2";
                case 2:return "Page 3";

            }

            return null;
        }
    }

}
