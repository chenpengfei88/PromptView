package com.fe.promptview.widget;

import android.app.Activity;
import android.view.View;

/**
 * Created by chenpengfei on 2016/11/2.
 */
public class ChatPromptViewManager extends PromptViewHelper.PromptViewManager {

    public ChatPromptViewManager(Activity activity, String[] dataArray, Location location) {
        super(activity, dataArray, location);
    }

    public ChatPromptViewManager(Activity activity) {
        this(activity, new String[]{"复制", "粘贴", "转发"}, Location.TOP_LEFT);
    }

    public ChatPromptViewManager(Activity activity, Location location) {
        this(activity, new String[]{"复制", "粘贴", "转发"}, location);
    }


    @Override
    public View inflateView() {
        return new PromptView(activity);
    }

    @Override
    public void bindData(View view, String[] dataArray) {
        if(view instanceof PromptView) {
            PromptView promptView = (PromptView) view;
            promptView.setContentArray(dataArray);
            promptView.setOnItemClickListener(new PromptView.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    if(onItemClickListener != null) onItemClickListener.onItemClick(position);
                }
            });
        }
    }
}
