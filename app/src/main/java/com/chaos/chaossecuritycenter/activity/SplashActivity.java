package com.chaos.chaossecuritycenter.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chaos.chaossecuritycenter.R;
import com.chaos.chaossecuritycenter.utils.PreferenceCache;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {
    MyHandler myHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        myHandler = new MyHandler(this);
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initJump();

            }
        }, 2000);
    }

    private void initJump() {
        //指纹高优先级
        if (PreferenceCache.getFingerFlg()){
            //指纹已开启
            Intent intent = new Intent(SplashActivity.this,VerifyFingerActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        if (PreferenceCache.getGestureFlag()){
            Intent intent = new Intent(getApplicationContext(),ClosePatternPswActivity.class);
            //等于3为认证成功
            intent.putExtra("gestureFlg",3);
            startActivity(intent);
            finish();
            return;
        }
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    static class MyHandler extends Handler {
        private final WeakReference<SplashActivity> mActivty;

        public MyHandler(SplashActivity activity){
            mActivty =new WeakReference<SplashActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myHandler != null){
            myHandler.removeCallbacksAndMessages(null);
            myHandler = null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
