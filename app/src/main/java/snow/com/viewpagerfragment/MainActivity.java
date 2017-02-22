package snow.com.viewpagerfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import snow.com.viewpagerfragment.Fragment.ScreenSlidePagerFragment;

public class MainActivity extends FragmentActivity {

    private ViewPager mPager;
    private PagerAdapter mAdapter;
    private static final int NUM_PAGER = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        mPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        //mPager.setPageTransformer(true, new DepthPageTransformer());
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);

        }
    }

    public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_PAGER;
        }

        @Override
        public Fragment getItem(int position) {
            return new ScreenSlidePagerFragment();
        }


    }

}
