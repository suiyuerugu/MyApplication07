package com.example.wxj.myapplication07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShowMsg;
    private Button btnSuccess, btnFailed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvShowMsg = (TextView) findViewById(R.id.tv_show_msg);
        btnSuccess = (Button) findViewById(R.id.btn_success);
        btnFailed = (Button) findViewById(R.id.btn_failed);

        btnSuccess.setOnClickListener(this);
        btnFailed.setOnClickListener(this);
        //获取启动该Activity之前的Activity对应的Intent
        Intent intent = getIntent();
        String strUserName = intent.getStringExtra("UserName");
        String strUserPassword = intent.getStringExtra("UserPassword");

        tvShowMsg.setText("UserName:" + strUserName + "\n" + "UserPassword:" + strUserPassword);



    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(InfoActivity.this, MainActivity.class);

        switch (view.getId()) {
            case R.id.btn_success:
                intent.putExtra("MSG", "用户名或密码正确！");
                break;
            case R.id.btn_failed:
                intent.putExtra("MSG", "用户名或密码错误！");
                break;
        }
        //setResult的第一个参数对应上面onActivityResult的第二个参数，
        // 注意别把onActivityResult的第一个参数与第二个参数搞混淆了，一个是请求标记，一个是返回标记。
        //当新Activity关闭后，新Activity返回的数据通过Intent进行传递，
        // android平台会调用前面Activity的onActivityResult()方法，
        // 把存放了返回数据的Intent作为第三个输入参数传入，
        // 在onActivityResult()方法中使用第三个输入参数可以取出新Activity返回的数据。
        setResult(1, intent);
        finish();
    }
}
