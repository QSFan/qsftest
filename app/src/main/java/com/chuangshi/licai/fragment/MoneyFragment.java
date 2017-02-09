package com.chuangshi.licai.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.chuangshi.licai.R;
import com.chuangshi.licai.adapter.ZhanDanAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends Fragment implements View.OnClickListener {


    private TextView tv_shouru;
    private LinearLayout ll_shouru;
    private TextView tv_zhichu;
    private LinearLayout ll_zhichu;
    private Button bt_addmoney;
    private ListView lv_money;

    private String[] ls = {"", "", "", "", "", "", "", "", "", "", "",};
    private List<String> list = new ArrayList<>();

    public MoneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_money, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

        tv_shouru = (TextView) view.findViewById(R.id.tv_shouru);
        ll_shouru = (LinearLayout) view.findViewById(R.id.ll_shouru);
        ll_shouru.setOnClickListener(this);
        tv_zhichu = (TextView) view.findViewById(R.id.tv_zhichu);
        ll_zhichu = (LinearLayout) view.findViewById(R.id.ll_zhichu);
        ll_zhichu.setOnClickListener(this);
        bt_addmoney = (Button) view.findViewById(R.id.bt_addmoney);
        bt_addmoney.setOnClickListener(this);
        lv_money = (ListView) view.findViewById(R.id.lv_money);

        list.add("1");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("2");
        list.add("1");
        list.add("1");
        list.add("1");

        ZhanDanAdapter adapter = new ZhanDanAdapter(getContext(), list);
        lv_money.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_shouru://收入
                break;
            case R.id.ll_zhichu://支出
                break;

            case R.id.bt_addmoney://添加账单
                break;
        }
    }
}
