package com.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class OutCallResponseDTO {

    /**
     * 0 表成功，
     *   1 任务进行中
     * 其他 表失败
     */
    private Integer code;

    /**
     * 错误提示信息
     */
    private String msg;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务描述
     */
    private String taskDesc;

    /**
     * 呼叫数据总数
     */
    private Integer total;


    /**
     * 已呼叫数
     */
    private Integer send;

    /**
     * 成功总数
     */
    private Integer success;

    /**
     * 任务状态
     */
    private Integer status;

    /**
     * 呼叫结果返回数据
     */
    private List<OutCallResultData> data;




}
