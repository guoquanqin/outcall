package com.example.enums;

/**
 * @Description: 外呼机器人链接
 * @Author: QQ
 * @Date: 2020/6/4
 */
public enum EnumOutCallUrl {

    UPLOADCALLDATA("外呼名单导入","uploadCallData"),
    STARTCALL("开始呼叫","startCall"),
    GETTASKDETAIL("查询呼叫结果","getTaskDetail"),
    CHANGETASKSTATUS("改变任务状态","changeTaskStatus"),
    OUTCALLURL("外呼接口","http://47.92.225.212:6002/index.php/CommonTask/")
    ;
    private String desc;
    private String uri;

    EnumOutCallUrl(String desc, String uri) {
        this.desc = desc;
        this.uri = uri;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
