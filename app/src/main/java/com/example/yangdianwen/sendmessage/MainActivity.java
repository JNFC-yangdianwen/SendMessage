package com.example.yangdianwen.sendmessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText_number;
    private EditText mEditText_content;
    private Button mButton_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void send(View view) {
        mEditText_number = (EditText) findViewById(R.id.et_input_number);
        mEditText_content = (EditText) findViewById(R.id.et_content);
        mButton_send = (Button) findViewById(R.id.btn_send);
        String number = mEditText_number.getText().toString();
        String content = mEditText_content.getText().toString();
        //直接使用系统发短信服务
        SmsManager sm=SmsManager.getDefault();
        //把长短信截短
        ArrayList<String>smss=sm.divideMessage(content);
        for (String string: smss
             ) {
            //arg0目标号码  arg1 短信中心号码    arg2 短信内容  arg3如果不为空是一个广播
            sm.sendTextMessage(number ,null,string,null,null);
        }


    }
}
