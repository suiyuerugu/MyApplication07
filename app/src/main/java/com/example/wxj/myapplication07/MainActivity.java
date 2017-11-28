package com.example.wxj.myapplication07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUserName,etUserPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName=(EditText)findViewById(R.id.et_user_name);
        etUserPassword=(EditText)findViewById(R.id.et_password);

        btnLogin=(Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        //取得编辑框中的内容
        String strUserName=etUserName.getText().toString();
        String strUserPassword=etUserPassword.getText().toString();
        //创建Intent对象，参数分别为上下文，要跳转的Activity类
        Intent intent=new Intent(MainActivity.this,InfoActivity.class);
        //将要传递的值附加到Intent对象
        intent.putExtra("UserName",strUserName);
        intent.putExtra("UserPassword",strUserPassword);
        //启动指定Activity并等待返回的结果，1是请求码。用于表示该请求
        startActivityForResult(intent,1);
    }
       //重写该方法，以回调的形式来获取Activity返回的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:
                Toast.makeText(this,data.getStringExtra("MSG"),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
