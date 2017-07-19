package com.xushuai.ceshi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * date:2017/7/11
 * author:徐帅(acer)
 * funcation:多条目适配器
 */

public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    //三种类型的ViewType
    private int header = 0;
    private int content = 1;
    private int footer = 2;

    public MultiAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = inflater.inflate(R.layout.header, parent, false);
            HViewHolder hViewHolder = new HViewHolder(view);
            return hViewHolder;
        } else if (viewType == footer) {
            View view = inflater.inflate(R.layout.footer, parent, false);
            FViewHolder fViewHolder = new FViewHolder(view);
            return fViewHolder;
        } else {
            View view = inflater.inflate(R.layout.main_item, parent, false);
            CViewHolder cViewHolder = new CViewHolder(view);
            return cViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HViewHolder) {
            HViewHolder hViewHolder = (HViewHolder) holder;
            hViewHolder.text.setText("我是Header");
        }
        if (holder instanceof FViewHolder) {
            FViewHolder fViewHolder = (FViewHolder) holder;
            fViewHolder.text.setText("我是footer");
        }
        if (holder instanceof CViewHolder) {
            CViewHolder cViewHolder = (CViewHolder) holder;
            cViewHolder.text.setText(list.get(position - 1));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return header;
        } else if (position == list.size() + 1) {
            return footer;
        } else {
            return content;
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 2;
    }


    class HViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public HViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.header);
        }
    }

    class FViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public FViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.footer);
        }
    }

    class CViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public CViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    interface OnItemClickLinstener {
        void onItemClickLinstener(int position, View view);

        void onItemLongClickLinstener(int position, View view);
    }

    public OnItemClickLinstener listener;

    public void setOnItemClickListener(OnItemClickLinstener listener) {
        this.listener = listener;
    }
}