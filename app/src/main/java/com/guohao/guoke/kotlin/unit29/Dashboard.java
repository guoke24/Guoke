package com.guohao.guoke.kotlin.unit29;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Dashboard {

    private final OkHttpClient mOkHttpClient = new OkHttpClient();
    private final Request mRequest = new Request.Builder().url("https://baidu.com").get().build();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    // java 的方式使用 okhttp
    public void display(final TextView textView) {
        mOkHttpClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                // 切线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(string);
                    }
                });
            }
        });

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Log.e("guohao","开始");
//                    Response response = mOkHttpClient.newCall(mRequest).execute();
//                    Log.e("guohao",response.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

    }
}
