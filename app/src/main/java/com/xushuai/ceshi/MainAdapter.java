package com.xushuai.ceshi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * date:2017/7/12
 * author:徐帅(acer)
 * funcation:
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CViewHolder> {

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;

    public MainAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_item, parent, false);
        CViewHolder viewHolder = new CViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CViewHolder holder, final int position) {
        holder.text.setText(list.get(position));
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClickListener(position, v);
            }
        });

        holder.text.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClickListener(position, v);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public CViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    interface OnItemClickListener {
        void onItemClickListener(int position, View view);

        void onItemLongClickListener(int position, View view);
    }

    public OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}