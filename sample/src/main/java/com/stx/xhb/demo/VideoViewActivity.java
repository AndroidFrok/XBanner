package com.stx.xhb.demo;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.stx.xhb.demo.holder.BannerHolderCreator;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.CustomViewsInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * 视频图片混合轮播
 * Demo只是给个例子参考，更多自定义功能需要根据自身需求去实现
 * 框架本身只是个轮播框架，支持各种自定义布局
 */
public class VideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_views);
        initView();
    }

    private void initView() {
        XBanner banner = (XBanner) findViewById(R.id.banner);
        List<CustomViewsInfo> data = new ArrayList<>();
        data.add(new CustomViewsInfo("https://hnwzgxsyy.test.jhwangluo.com/uploads/20241101/552e51842a5bee9147aec6eac836e70a.mp4", 2));
        data.add(new CustomViewsInfo("https://hnwzgxsyy.test.jhwangluo.com/uploads/20241101/288656818cc71a7e866f0990a91a2090.jpg", 1));
        data.add(new CustomViewsInfo("http://hnwzgxsyy.test.jhwangluo.com/uploads/20241101/288656818cc71a7e866f0990a91a2090.jpg", 1));
        data.add(new CustomViewsInfo("http://hnwzgxsyy.test.jhwangluo.com/uploads/20241101/552e51842a5bee9147aec6eac836e70a.mp4", 2));
        final BannerHolderCreator holderCreator = new BannerHolderCreator();
        banner.setBannerData(data, holderCreator);
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                ToastUtils.showShort("点击了" + position);
            }
        });
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                Log.i("onPageScrolled=", i + "");
            }

            @Override
            public void onPageSelected(int i) {
                Log.i("onPageSelected=", i + "");
                if (i == 0) {
                    holderCreator.videoViewHolder.videoView.start();
                } else {
                    holderCreator.videoViewHolder.videoView.pause();
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                Log.i("ScrollStateChanged=", i + "");
            }
        });
    }

}
