package com.android.lambdademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
/*Lambda的插件地址：https://github.com/evant/gradle-retrolambda*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = new Button(this);
        //普通写法
        new Thread(new Runnable() {
            public void run() {
                Log.d("输出:", "Hello World!");
            }
        }).start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.postDelayed(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("延迟2秒", "输出按钮!");
                    }
                }),2000);
            }
        });

        //Lambda表达式
        new Thread(()->{
            Log.d("输出:", "Hello World!");
        });
        button.setOnClickListener(view ->{
            view.postDelayed(() ->{
                Log.d("延迟2秒", "输出按钮!");
            },2000);
        });
    }

}
