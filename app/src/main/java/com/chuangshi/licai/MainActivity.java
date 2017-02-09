package com.chuangshi.licai;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chuangshi.licai.fragment.MessageFragment;
import com.chuangshi.licai.fragment.MoneyFragment;
import com.chuangshi.licai.fragment.MyFragment;
import com.chuangshi.licai.fragment.ShareFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout fragment_main;
    private RadioButton rb_money;
    private RadioButton rb_share;
    private RadioButton rb_message;
    private RadioButton rb_my;
    private RadioGroup radioGroup;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
        initView();
    }

    private void initView() {
        fragment_main = (FrameLayout) findViewById(R.id.fragment_main);
        rb_money = (RadioButton) findViewById(R.id.rb_money);
        rb_share = (RadioButton) findViewById(R.id.rb_share);
        rb_message = (RadioButton) findViewById(R.id.rb_message);
        rb_my = (RadioButton) findViewById(R.id.rb_my);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        //默然打开程序选择第一个
        rb_money.setChecked(true);
    }

    /**
     * 初始化Fragment
     */
    private void initFragments() {
        fragments.add(new MessageFragment());
        fragments.add(new ShareFragment());
        fragments.add(new MoneyFragment());
        fragments.add(new MyFragment());
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_money:
                changeFragment(0);
                break;
            case R.id.rb_share:
                changeFragment(1);
                break;
            case R.id.rb_message:
                changeFragment(2);
                break;
            case R.id.rb_my:
                changeFragment(3);
                break;
            default:
                break;
        }
    }

    /**
     * 选择对应Fragment
     */
    private Fragment lastFragment;

    private void changeFragment(int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (lastFragment != null) {
            transaction.hide(lastFragment);
        }

        Fragment fragment = fragments.get(i);

        if (fragment.isAdded()) {
            transaction.show(fragment);

        } else {
            transaction.add(R.id.fragment_main, fragment);
        }

        transaction.commit();
        lastFragment = fragment;

    }


    /**
     * 双击返还建退出应用
     */
    private static boolean mBackPressed = false;

    @Override
    public void onBackPressed() {

        if (!mBackPressed) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mBackPressed = true;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mBackPressed = false;
                }
            }, 2000);
        } else {
            this.finish();
            System.exit(0);
            super.onBackPressed();
        }
    }
}
