package com.stx.xhb.demo.holder;

import android.view.View;

import com.stx.xhb.demo.R;
import com.stx.xhb.xbanner.entity.CustomViewsInfo;
import com.stx.xhb.xbanner.holder.ViewHolder;

import xyz.doikki.videocontroller.StandardVideoController;
import xyz.doikki.videoplayer.player.VideoView;

public class VideoViewHolder implements ViewHolder<CustomViewsInfo> {
    public VideoView videoView;

    @Override
    public int getLayoutId() {
        return R.layout.layout_video_view;
    }

    @Override
    public void onBind(View itemView, CustomViewsInfo data, int position) {
        videoView = itemView.findViewById(R.id.player);
        videoView.setUrl(data.getXBannerUrl());
        StandardVideoController controller = new StandardVideoController(itemView.getContext());
        controller.addDefaultControlComponent("标题"+data.getXBannerTitle(), false);
        videoView.setVideoController(controller); //设置控制器
    }
}
