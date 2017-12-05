package com.chaos.chaossecuritycenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chaos.chaossecuritycenter.R;
import com.chaos.chaossecuritycenter.utils.PreferenceCache;
import com.chaos.chaossecuritycenter.weight.ChaosGestureView;

import java.util.List;

public class SettingPatternPswActivity extends AppCompatActivity implements ChaosGestureView.GestureCallBack{
    private TextView tv_back;
    private ChaosGestureView gestureView;
    private int jumpFlg;
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_pattern_psw);
        jumpFlg = getIntent().getIntExtra("jumpFlg", 0);
        flag = getIntent().getIntExtra("flag", 0);
        initView();
    }

    private void initView() {
        tv_back = (TextView) findViewById(R.id.tv_setting_back);
        gestureView = (ChaosGestureView) findViewById(R.id.gesture);
        gestureView.setGestureCallBack(this);
        //不调用这个方法会造成第二次启动程序直接进入手势识别而不是手势设置
        gestureView.clearCache();
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void gestureVerifySuccessListener(int stateFlag, List<ChaosGestureView.GestureBean> data, boolean success) {
        if (stateFlag == ChaosGestureView.STATE_LOGIN) {
            PreferenceCache.putGestureFlag(true);
            finish();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
