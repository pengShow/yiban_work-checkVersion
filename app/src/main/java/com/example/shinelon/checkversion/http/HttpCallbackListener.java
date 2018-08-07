package com.example.shinelon.checkversion.http;

public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}