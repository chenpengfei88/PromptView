package com.fe.promptview.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fe.promptview.Message;
import com.fe.promptview.R;
import com.fe.promptview.widget.ChatPromptViewManager;
import com.fe.promptview.widget.Location;
import com.fe.promptview.widget.PromptViewHelper;

import java.util.List;

/**
 * Created by chenpengfei on 2016/10/27.
 */
public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Message> mMessageList = null;
    private Activity mActivity;

    public MyAdapter(Activity activity, List<Message> messageList) {
        mActivity = activity;
        mMessageList = messageList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 1) {
            return new LeftViewHolder(View.inflate(mActivity, R.layout.activity_item_left, null));
        } else {
            return new RightViewHolder(View.inflate(mActivity, R.layout.activity_item_right, null));
        }
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMessageList.get(position).getType();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        PromptViewHelper pvHelper = new PromptViewHelper(mActivity);
        Message message = mMessageList.get(position);
        if(holder instanceof LeftViewHolder) {
            LeftViewHolder leftViewHolder = (LeftViewHolder) holder;
            leftViewHolder.tv.setText(message.getContent());
            pvHelper.setPromptViewManager(new ChatPromptViewManager(mActivity));
        }
        if(holder instanceof RightViewHolder) {
            RightViewHolder rightViewHolder = (RightViewHolder) holder;
            rightViewHolder.tv.setText(message.getContent());
            pvHelper.setPromptViewManager(new ChatPromptViewManager(mActivity, Location.TOP_RIGHT));
        }
        pvHelper.addPrompt(holder.itemView.findViewById(R.id.textview_content));
        pvHelper.setOnItemClickListener(new PromptViewHelper.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String str = "";
                switch (position) {
                    case 0:
                        str = "复制";
                        break;
                    case 1:
                        str = "粘贴";
                        break;
                    case 2:
                        str = "转发";
                        break;
                }
                Toast.makeText(mActivity,  str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class LeftViewHolder extends BaseViewHolder {

        TextView tv;

        public LeftViewHolder(View view) {
            super(view);
            tv = (TextView) findViewById(R.id.textview_content);
        }
    }

    class RightViewHolder extends BaseViewHolder {

        TextView tv;

        public RightViewHolder(View view) {
            super(view);
            tv = (TextView) findViewById(R.id.textview_content);
        }
    }
}
