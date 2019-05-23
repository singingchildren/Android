package com.wangzijie.nutrition_user.ui.mine;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.wangzijie.nutrition_user.R;
import com.wangzijie.nutrition_user.ui.fragment.MyVipFragment;



/**
 * 会员手册
 */
public class MyVipActivity extends AppCompatActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vip);
        viewPager = findViewById(R.id.my_viewpage);
        viewPager.setOffscreenPageLimit(1);


        //数据适配器
        FragmentStatePagerAdapter mPagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            //获取当前窗体界面数
            public int getCount() {
                // TODO Auto-generated method stub
                return 15;
            }

            @Override
            public Fragment getItem(int position) {
                return new MyVipFragment(position);
            }
        };

        //绑定适配器
        viewPager.setAdapter(mPagerAdapter);


    }


}
