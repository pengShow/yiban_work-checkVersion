package com.example.shinelon.checkversion.presenter;

import android.util.Log;

import com.example.shinelon.checkversion.http.HttpUtil;
import com.example.shinelon.checkversion.iView.MainIView;
import com.example.shinelon.checkversion.result.MainResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Peng on 2017/7/31.
 */

public class MainPresenter {
    private MainIView iView;

    public MainPresenter(MainIView iView) {
        this.iView = iView;
    }

    /**
     * 添加记录的回调
     *
     * @param url
     */
    public void add_record(String url) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iView.toastData("添加失败，请重新请求！");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                MainResult mainResult = parseJSONWithGSON(responseData);
                if (null != mainResult) {
                    iView.toastData(mainResult.getMsg());
                }
            }
        });
    }


    /**
     * 开启记录的回调
     *
     * @param url
     */
    public void open_record(String url) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iView.toastData("开启失败，请重新尝试！");
                iView.setView();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                MainResult mainResult = parseJSONWithGSON(responseData);
                if (null != mainResult) {
                    iView.toastData("开启正式成功");
                }
            }
        });
    }

    /**
     * 开启审核的回调
     *
     * @param url
     */
    public void close_record(String url) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iView.toastData("开启失败，请重新尝试！");
                iView.setView();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                MainResult mainResult = parseJSONWithGSON(responseData);
                Log.i("response2", response + "");
                if (null != mainResult) {
                    iView.toastData("开启审核成功");
                }

            }
        });
    }

    private MainResult parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        MainResult mainResult = gson.fromJson(jsonData, new TypeToken<MainResult>() {
        }.getType());
        return mainResult;
    }
}
