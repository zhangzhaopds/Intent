package com.tongxingpay.zhangzhao.mypay;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextView        show_btn_text;
    private Button          show_btn;
    private Button          currentBtn;
    private static int      REQUEST_ASK = 100;
    private static String   mainActivity_log = "MainActivity";


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ASK) {
            if (resultCode == 10) {
                show_btn_text.setText(data.getExtras().getString("Key_next"));
                Log.i(mainActivity_log, "onActivityResult: " + show_btn_text.getText());
            } else {
                Log.i(mainActivity_log, "onActivityResult: 处理错误");
            }
        } else {
            Log.i(mainActivity_log, "onActivityResult: 请求错误");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_btn_text = (TextView)findViewById(R.id.main_showBtn_text);
        show_btn = (Button)findViewById(R.id.main_button_ok);
        currentBtn = (Button)findViewById(R.id.main_currentBtn);

        // 跳转到欢迎界面
        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextIntent = new Intent();
                Bundle nextBundle = new Bundle();
                nextBundle.putString("Key_main", "来自第一界面的扯淡哥");
                nextIntent.putExtras(nextBundle);   // putExtras()方法必须调用,不然程序挂掉
                nextIntent.setClass(MainActivity.this, WelcomeActivity.class);
                startActivityForResult(nextIntent, REQUEST_ASK);

            }
        });

        // 打开网页
        currentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri myUri = Uri.parse("http://tongxingpay.com");
                Intent currentIntent = new Intent(Intent.ACTION_VIEW, myUri);
                startActivity(currentIntent);
            }
        });







    }
}
