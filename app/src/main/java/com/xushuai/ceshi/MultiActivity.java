package com.xushuai.ceshi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MultiActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i < 101; i++) {
            list.add(i + " ");
        }

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview_id);

        MultiAdapter adapter = new MultiAdapter(this, list);
        recyclerview.setAdapter(adapter);

        /**
         * 设置布局管理器
         * 参数一：上下文。参数二：表示水平垂直滑动。参数三：false默认是从上到下显示数据
         * 参数可以只写参数一，参数二参数三不写的情况下，默认是纵向的
         */
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);

        //表格布局效果，相当于GridView ，第二个参数是每行显示几个
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
//        recyclerview.setLayoutManager(gridLayoutManager);

        //瀑布流，第一个参数是显示的行数
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
//        recyclerview.setLayoutManager(staggeredGridLayoutManager);

        adapter.setOnItemClickListener(new MultiAdapter.OnItemClickLinstener() {
            @Override
            public void onItemClickLinstener(int position, View view) {
                Toast.makeText(MultiActivity.this, "单击了" + (position + 1), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickLinstener(int position, View view) {
                Toast.makeText(MultiActivity.this, "长按了" + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}