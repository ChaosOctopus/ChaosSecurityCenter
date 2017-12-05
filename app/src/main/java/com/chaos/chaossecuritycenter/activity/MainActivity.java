package com.chaos.chaossecuritycenter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chaos.chaossecuritycenter.GlideApp;
import com.chaos.chaossecuritycenter.utils.PreferenceCache;
import com.chaos.chaossecuritycenter.R;
import com.chaos.chaossecuritycenter.utils.AlertUtil;
import com.chaos.chaossecuritycenter.utils.BitmapCircleTransformation;
import com.wei.android.lib.fingerprintidentify.FingerprintIdentify;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mIvHandSwitch;
    private ImageView mIvFingerSwitch;
    private LinearLayout mlinearLayputSetting;
    private View mView;
    private FingerprintIdentify mFingerprintIdentify;
    private ImageView iv_icon_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //处理页面
        initData();
    }

    private void initData() {
        if (PreferenceCache.getGestureFlag()){
            mIvHandSwitch.setImageResource(R.mipmap.auto_bidding_off);
            mlinearLayputSetting.setVisibility(View.VISIBLE);
            mView.setVisibility(View.VISIBLE);
        }else{
            mIvHandSwitch.setImageResource(R.mipmap.auto_bidding_on);
            mlinearLayputSetting.setVisibility(View.GONE);
            mView.setVisibility(View.GONE);
        }

        if (PreferenceCache.getFingerFlg()){
            mIvFingerSwitch.setImageResource(R.mipmap.auto_bidding_off);
        }else{
            mIvFingerSwitch.setImageResource(R.mipmap.auto_bidding_on);
        }
    }

    private void initView() {
        mIvHandSwitch = (ImageView) findViewById(R.id.iv_hand_switch);
        mIvFingerSwitch = (ImageView) findViewById(R.id.iv_fingerprint_switch);
        mIvFingerSwitch.setOnClickListener(this);
        mIvHandSwitch.setOnClickListener(this);
        mlinearLayputSetting = (LinearLayout) findViewById(R.id.ll_setting_hand);
        mlinearLayputSetting.setOnClickListener(this);
        mView = findViewById(R.id.view_second);
        mFingerprintIdentify = new FingerprintIdentify(this);
        iv_icon_main = findViewById(R.id.iv_icon_main);
        GlideApp.with(MainActivity.this).load(R.mipmap.alaska).transforms(new BitmapCircleTransformation(MainActivity.this)).into(iv_icon_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_hand_switch:
                if (!PreferenceCache.getGestureFlag()){
                    Intent intent = new Intent(MainActivity.this,SettingPatternPswActivity.class);
                    startActivityForResult(intent,1);
                }else{
                    Intent close_intent = new Intent(MainActivity.this,ClosePatternPswActivity.class);
                    //等于1为删除密码
                    close_intent.putExtra("gestureFlg", 1);
                    startActivityForResult(close_intent,1);
                }
                break;
            case R.id.ll_setting_hand:
                Intent intent = new Intent(MainActivity.this,ClosePatternPswActivity.class);
                //等于2为修改密码
                intent.putExtra("gestureFlg",2);
                startActivityForResult(intent,1);
                break;
            case R.id.iv_fingerprint_switch:
                if (mFingerprintIdentify.isHardwareEnable()){
                    //指纹可用
                    if (mFingerprintIdentify.isFingerprintEnable()){
                        if (PreferenceCache.getFingerFlg()){
                            //取消指纹
                            mIvFingerSwitch.setImageResource(R.mipmap.auto_bidding_on);
                            AlertUtil.t(MainActivity.this,"指纹验证功能已取消");
                            PreferenceCache.putFingerFlg(false);
                        }else{
                            //打开指纹
                            mIvFingerSwitch.setImageResource(R.mipmap.auto_bidding_off);
                            AlertUtil.t(MainActivity.this,"指纹验证功能已打开");
                            PreferenceCache.putFingerFlg(true);
                        }

                    }else{
                        AlertUtil.t(MainActivity.this,"请先去录入指纹");
                    }
                }else{
                    AlertUtil.t(MainActivity.this,"辣鸡手机，用不了指纹，换手机吧");
                }
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            initData();
        }
    }
}
