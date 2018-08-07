package com.example.shinelon.checkversion.interfaces;

import java.util.ArrayList;

/**
 * Created by Peng on 2017/7/31.
 */

public class Constant {
    /**
     * 基本域名
     */
    public static String BASE_URL = "http://ttt.cshuaiw.com/";
    /**
     * 添加记录
     */
    public static String ADD_RECORD = BASE_URL + "ace/add_version?platform=1";
    /**
     * 开启记录
     */
    public static String OPEN_RECORD = BASE_URL + "ace/del_version?platform=1&del=0";

    /**
     * 关闭记录
     */
    public static String CLOSE_RECORD = BASE_URL + "ace/del_version?platform=1&del=1";


    /**
     * 渠道数据
     */
    public static final String[] CHANNELS = {"oppo", "samsung", "aliyun", "chuizi", "lenovo", "leshi", "sougou", "vivo", "huawei", "huawei_2", "yingyonghui", "_360", "xiaomi", "jifeng", "yingyongbao", "yingyongbao_4", "yingyongbao_6", "yingyongbao_9", "baidu", "meizu", "anzhi"};


    /**
     * 渠道默认数据
     */
    public static ArrayList<String> channelData;

    public static ArrayList<String> getChannelData() {
        channelData = new ArrayList<>();
        // 将数组转换成list
        for (int i = 0; i < CHANNELS.length; i++) {
            channelData.add(CHANNELS[i]);
        }
        return channelData;
    }

    public static void setChannelData(ArrayList<String> channelData) {
        Constant.channelData = channelData;
    }
    /**
     * 保存
     */
    public static final String CLVNVI = "clvnvi";
    /**
     * 保存CHANNELS
     */
    public static final String CL = "cl";
    /**
     * 保存versionName
     */
    public static final String VN = "vn";

    /**
     * 保存versionId
     */
    public static final String VI = "vi";

}
