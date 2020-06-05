package com.example.dto;

import lombok.Data;

@Data
public class TimeRangeDTO {

    /**
     * 开始时间 格式：yyyy-MM-dd HH:mm:ss
     */
    private String startTime;

    /**
     * 截止时间 格式：yyyy-MM-dd HH:mm:ss
     */
    private String endTime;
}
