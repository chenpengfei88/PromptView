package com.fe.promptview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fe.promptview.Message;
import com.fe.promptview.R;
import com.fe.promptview.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(this, getMessageList()));
    }

    private List<Message> getMessageList() {
        List<Message> messageList = new ArrayList<>(11);
        messageList.add(new Message("队长别开枪，是我"));
        messageList.add(new Message("是——你小子", 2));
        messageList.add(new Message("是你老子我"));
        messageList.add(new Message("啊！是你把敌人引到这儿来的？ ", 2));
        messageList.add(new Message("恩……嘿嘿……队长。（嬉皮笑脸）呃黄军让 我给您带个话儿（边说边把朱引得背对观众）只要 你能够投降黄军"));
        messageList.add(new Message("哎！等等！我怎么成了背对观众了", 2));
        messageList.add(new Message("我怎么知道"));
        messageList.add(new Message("你位置站错了吧！", 2));
        messageList.add(new Message("你说怎么站"));
        messageList.add(new Message("你这么站！ ", 2));
        messageList.add(new Message("我干吗这么站"));
        return messageList;
    }
}
