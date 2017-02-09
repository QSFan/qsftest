package com.chuangshi.licai.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chuangshi.licai.R;

import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 */
public class ZhanDanAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public ZhanDanAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_zhang_dan, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (list.get(position).equals("2")) {
            holder.ll_zhangdan.setBackgroundResource(R.drawable.shape_zhichu);
        } else {
            holder.ll_zhangdan.setBackgroundResource(R.drawable.shape_shouru);

        }
        holder.tv_money.setText(list.get(position));

        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView tv_money;
        public LinearLayout ll_zhangdan;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_money = (TextView) rootView.findViewById(R.id.tv_money);
            this.ll_zhangdan = (LinearLayout) rootView.findViewById(R.id.ll_zhangdan);
        }

    }
}
