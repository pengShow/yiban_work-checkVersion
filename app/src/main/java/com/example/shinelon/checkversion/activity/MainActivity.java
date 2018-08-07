package com.example.shinelon.checkversion.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.shinelon.checkversion.R;
import com.example.shinelon.checkversion.iView.MainIView;
import com.example.shinelon.checkversion.interfaces.Constant;
import com.example.shinelon.checkversion.presenter.MainPresenter;
import com.example.shinelon.checkversion.utils.SharedPreferencesUtils;
import com.example.shinelon.checkversion.utils.ToastUtils;
import com.example.shinelon.checkversion.widge.SwitchButton;

import org.zackratos.ultimatebar.UltimateBar;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainIView, View.OnClickListener {
    AutoCompleteTextView actv_channel;
    AutoCompleteTextView actv_version_name;
    AutoCompleteTextView actv_version_id;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> versionNameAdapter;
    ArrayAdapter<String> versionIdAdapter;

    String url;
    private Context mContext;
    MainPresenter presenter;

    private SwitchButton sb_text;
    private ArrayList<String> arrVersionName;
    private ArrayList<String> arrVersionid;
    private ArrayList<String> channelData;
    private Map<String, ?> clMap;
    private Map<String, ?> vnMap;
    private Map<String, ?> viMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setTransparentBar(Color.BLACK, 50);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);
        mContext = this;
        presenter = new MainPresenter(this);
        actv_channel = (AutoCompleteTextView) findViewById(R.id.actv_channel);
        actv_version_name = (AutoCompleteTextView) findViewById(R.id.actv_version_name);
        actv_version_id = (AutoCompleteTextView) findViewById(R.id.actv_version_id);
        sb_text = (SwitchButton) findViewById(R.id.sb_text);
        sb_text.setOnClickListener(this);
        actv_channel.setThreshold(1);
        actv_version_name.setThreshold(1);
        actv_version_id.setThreshold(1);
        actv_version_name.setKeyListener(DigitsKeyListener.getInstance("1234567890."));
        getRecord();
        arrVersionName = new ArrayList<String>();
        arrVersionid = new ArrayList<String>();
        channelData = new ArrayList<String>();


        if (null != SharedPreferencesUtils.getAll(mContext, Constant.CL) && SharedPreferencesUtils.getAll(mContext, Constant.CL).size() > 0) {
            clMap = SharedPreferencesUtils.getAll(mContext, Constant.CL);
            channelData = mapToAL(clMap);
            channelData.addAll(Constant.getChannelData());
        } else {
            channelData = Constant.getChannelData();
        }

        if (null != SharedPreferencesUtils.getAll(mContext, Constant.VN) && SharedPreferencesUtils.getAll(mContext, Constant.VN).size() > 0) {
            vnMap = SharedPreferencesUtils.getAll(mContext, Constant.VN);
            arrVersionName = mapToAL(vnMap);
        }

        if (null != SharedPreferencesUtils.getAll(mContext, Constant.VI) && SharedPreferencesUtils.getAll(mContext, Constant.VI).size() > 0) {
            viMap = SharedPreferencesUtils.getAll(mContext, Constant.VI);
            arrVersionid = mapToAL(viMap);
        }


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, channelData);
        actv_channel.setAdapter(arrayAdapter);
        versionNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrVersionName);
        actv_version_name.setAdapter(versionNameAdapter);
        versionIdAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrVersionid);
        actv_version_id.setAdapter(versionIdAdapter);
    }

    //添加记录
    public void add_record(View view) {
        view.setEnabled(false);
        //ttt.cshuaiw.com/ace/add_version?version_id=112&channel=samsung&platform=1&version=2.3
        if (isInput()) {
            view.setEnabled(true);
            url = Constant.ADD_RECORD + getParam();
            presenter.add_record(url);
        } else {
            view.setEnabled(true);
        }

    }

    //开启线上页面
    public void openCheck(View view) {
        view.setEnabled(false);
        //ttt.cshuaiw.com/ace/del_version?version_id=112&channel=samsung&platform=1&version=2.3&del=0
        if (isInput()) {
            view.setEnabled(true);
            url = Constant.OPEN_RECORD + getParam();
            presenter.open_record(url);
        } else {
            view.setEnabled(true);
        }


    }

    //开启审核页面
    public void closeCheck(View view) {
        view.setEnabled(false);
        //关闭 ttt.cshuaiw.com/ace/del_version?version_id=112&channel=samsung&platform=1&version=2.3&del=1
        if (isInput()) {
            view.setEnabled(true);
            url = Constant.CLOSE_RECORD + getParam();
            presenter.close_record(url);
        } else {
            view.setEnabled(true);
        }

    }

    /**
     * 判断是否请求
     *
     * @return
     */
    public boolean isInput() {
        if (TextUtils.isEmpty(actv_channel.getText().toString().trim())) {
            ToastUtils.toast(mContext, getResources().getString(R.string.input_channel));
            return false;
        } else if (TextUtils.isEmpty(actv_version_name.getText().toString().trim())) {
            ToastUtils.toast(mContext, getResources().getString(R.string.input_version_name));
            return false;
        } else if (TextUtils.isEmpty(actv_version_id.getText().toString().trim())) {
            ToastUtils.toast(mContext, getResources().getString(R.string.input_version_id));
            return false;
        }
        String versionName = actv_version_name.getText().toString().trim();
        String versionId = actv_version_id.getText().toString().trim();
        String channel = actv_channel.getText().toString().trim();
        if (!Constant.getChannelData().contains(channel)) {
            channelData.add(channel);
            SharedPreferencesUtils.put(mContext, Constant.CL, channel, channel);
        }

        arrVersionName.add(versionName);
        arrVersionid.add(versionId);
        SharedPreferencesUtils.put(mContext, Constant.VN, versionName, versionName);
        SharedPreferencesUtils.put(mContext, Constant.VI, versionId, versionId);
        return true;
    }

    /**
     * channel/version_name/version_id 的参数拼接
     *
     * @return
     */
    public String getParam() {

        return "&channel=" + actv_channel.getText().toString().trim() + "&version=" + actv_version_name.getText().toString().trim() + "&version_id=" + actv_version_id.getText().toString().trim();
    }

    /**
     * 主要用来toast
     *
     * @param msg 返回的信息
     */
    @Override
    public void toastData(final String msg) {
        saveRecord();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.toast(mContext, msg);
            }
        });

    }

    @Override
    public void setView() {
        if (sb_text.isChecked()) {
            sb_text.setChecked(false);
        } else {
            sb_text.setChecked(true);
        }
    }


    @Override
    public void onClick(View view) {
        view.setEnabled(false);
        if (isInput() && view.getId() == R.id.sb_text) {
            switch (view.getId()) {
                case R.id.sb_text:
                    if (!sb_text.isChecked()) {
                        closeCheck(view);
                    } else {
                        openCheck(view);
                    }
                    break;
            }
        } else {
            setView();
            view.setEnabled(true);
        }

    }


    private ArrayList<String> mapToAL(Map<String, ?> map) {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, ?> entry1 : map.entrySet()) {
            String m1Key = entry1.getKey() == "" ? "" : entry1.getKey();
            if (!TextUtils.isEmpty(m1Key)) {
                list.add(m1Key);
            }
        }
        return list;
    }

    /**
     * 保存最新一次存储的记录
     */
    public void saveRecord() {
        SharedPreferencesUtils.put(mContext, Constant.CLVNVI, Constant.CL, actv_channel.getText().toString().trim());
        SharedPreferencesUtils.put(mContext, Constant.CLVNVI, Constant.VN, actv_version_name.getText().toString().trim());
        SharedPreferencesUtils.put(mContext, Constant.CLVNVI, Constant.VI, actv_version_id.getText().toString().trim());
    }

    /**
     * 获取最后一次保存的记录
     */
    public void getRecord() {
        if (null != SharedPreferencesUtils.get(mContext, Constant.CLVNVI, Constant.CL, "")) {
            actv_channel.setText((String) SharedPreferencesUtils.get(mContext, Constant.CLVNVI, Constant.CL, ""));
            actv_channel.setSelection(actv_channel.getText().toString().length());
        }
        if (null != SharedPreferencesUtils.get(mContext, Constant.CLVNVI, Constant.VN, "")) {
            actv_version_name.setText((String) SharedPreferencesUtils.get(mContext, Constant.CLVNVI, Constant.VN, ""));

        }
        if (null != SharedPreferencesUtils.get(mContext, Constant.CLVNVI, Constant.VI, "")) {
            actv_version_id.setText((String) SharedPreferencesUtils.get(mContext, Constant.CLVNVI, Constant.VI, ""));
        }

    }
}
