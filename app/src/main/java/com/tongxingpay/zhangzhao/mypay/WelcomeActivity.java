package com.tongxingpay.zhangzhao.mypay;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;


/**
 * Created by zhangzhao on 2016/9/27.
 */

public class WelcomeActivity extends AppCompatActivity {
    private Button backBtn;
    private TextView detailView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        backBtn = (Button)findViewById(R.id.welcome_backBtn);
        detailView = (TextView)findViewById(R.id.welcome_showBtn_text);

        Bundle myBundle = this.getIntent().getExtras();
        String name = myBundle.getString("Key_main");
        detailView.setText(name);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent();
                Bundle backBundle = new Bundle();
                backBundle.putString("Key_next", "我是来自第二个界面的外星人,很帅");
                backIntent.putExtras(backBundle);
                setResult(10, backIntent);

                // 只有finish()方法调用,才会返回上个界面
                finish();
            }
        });
    }
}
