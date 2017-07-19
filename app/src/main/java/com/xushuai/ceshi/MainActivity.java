package com.xushuai.ceshi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleview;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleview = (RecyclerView) findViewById(R.id.recyclerview_id);

        startActivity(new Intent(this, MultiActivity.class));

        for (int i = 1; i < 101; i++) {
            list.add(i + " ");
        }

        /**
         * 设置布局管理器
         * 参数一：上下文。参数二：表示水平垂直滑动。参数三：false默认是从上到下显示数据
         * 参数可以只写参数一，参数二参数三不写的情况下，默认是纵向的
         */
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycleview.setLayoutManager(manager);

        //表格布局效果，相当于GridView ，第二个参数是每行显示几个
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
//        recyclerview.setLayoutManager(gridLayoutManager);

        //瀑布流，第一个参数是显示的行数
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
//        recyclerview.setLayoutManager(staggeredGridLayoutManager);

        MainAdapter adapter = new MainAdapter(this, list);
        recycleview.setAdapter(adapter);

        adapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, View view) {
                Toast.makeText(MainActivity.this, "当前单击了" + (position + 1), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(int position, View view) {
                Toast.makeText(MainActivity.this, "当前长按了" + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}