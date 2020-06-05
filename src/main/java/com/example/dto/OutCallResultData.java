package com.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class OutCallResultData {

    /**
     * 任务唯一标识
     */
    private String requestId;

    /**
     * 呼叫数据唯一标识
     */
    private String custId;

    /**
     * 呼叫号码
     */
    private String callee;

    /**
     * 外显号码
     */
    private String caller;

    /**
     * 拨打结果
     */
    private String result;

    /**
     * 呼通号码
     */
    private String callee_number;

    /**
     * 用户自带的信息
     */
    private String userData;

    /**
     * 会话时长
     */
    private Integer talkTimes;

    /**
     * Ai标签
     */
    private String aiStatus;

    /**
     * 呼叫开始时间
     */
    private String start_at;

    /**
     * 呼叫结束时间
     */
    private String end_at;

    /**
     * 录音路径
     */
    private String recordPath;

    /**
     * 呼叫结束时间
     */
    private List<RecordInfo> exception;
}
