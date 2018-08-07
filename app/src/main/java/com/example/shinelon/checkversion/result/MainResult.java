package com.example.shinelon.checkversion.result;

/**
 * Created by Peng on 2017/7/31.
 */

public class MainResult  {

    /**
     * msg : 添加成功
     * code : 1
     * obj : {"create_time":"2017-07-31 16:27:17","channel":"meizu","remark":"","version_id":36,"apple_id":"","version":"2.2","url":"","descp":"攻城狮已经通宵把新版本赶出来了，同时新增用户只会在新版本展示哦。\n赶紧去更新，看看最新注册的帅哥美女吧！","platform_type":1,"is_alive":1,"admin_id":0,"is_del":0,"id":49}
     */

    private String msg;
    private int code;
    private ObjBean obj;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * create_time : 2017-07-31 16:27:17
         * channel : meizu
         * remark :
         * version_id : 36
         * apple_id :
         * version : 2.2
         * url :
         * descp : 攻城狮已经通宵把新版本赶出来了，同时新增用户只会在新版本展示哦。
         赶紧去更新，看看最新注册的帅哥美女吧！
         * platform_type : 1
         * is_alive : 1
         * admin_id : 0
         * is_del : 0
         * id : 49
         */

        private String create_time;
        private String channel;
        private String remark;
        private int version_id;
        private String apple_id;
        private String version;
        private String url;
        private String descp;
        private int platform_type;
        private int is_alive;
        private int admin_id;
        private int is_del;
        private int id;

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getVersion_id() {
            return version_id;
        }

        public void setVersion_id(int version_id) {
            this.version_id = version_id;
        }

        public String getApple_id() {
            return apple_id;
        }

        public void setApple_id(String apple_id) {
            this.apple_id = apple_id;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescp() {
            return descp;
        }

        public void setDescp(String descp) {
            this.descp = descp;
        }

        public int getPlatform_type() {
            return platform_type;
        }

        public void setPlatform_type(int platform_type) {
            this.platform_type = platform_type;
        }

        public int getIs_alive() {
            return is_alive;
        }

        public void setIs_alive(int is_alive) {
            this.is_alive = is_alive;
        }

        public int getAdmin_id() {
            return admin_id;
        }

        public void setAdmin_id(int admin_id) {
            this.admin_id = admin_id;
        }

        public int getIs_del() {
            return is_del;
        }

        public void setIs_del(int is_del) {
            this.is_del = is_del;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
