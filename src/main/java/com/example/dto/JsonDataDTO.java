package com.example.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class JsonDataDTO {
    /**
     * 每条呼叫唯一标识
     * 一条呼叫的唯一标识，不可重复，后续查询使用
     */
    private String custId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 外显号
     * 如果配置了，优先使用这里的外显配置，只能是单个外显号
     */
    private String caller;
    /**
     * 呼叫号码1
     */
    private String phoneNum1;
    /**
     * 呼叫号码2
     */
    private String phoneNum2;
    /**
     * 呼叫号码3
     */
    private String phoneNum3;
    /**
     * 呼叫号码4
     */
    private String phoneNum4;
    /**
     * 呼叫号码5
     */
    private String phoneNum5;

    /**
     * 需要带入的用户信息，所有信息会json后入库，json后的字符串长度不得超过2000个字符
     */
    private UserData userData;

    /**
     * 初始化每条呼叫唯一标识
     */
    public void initCustId(){
        this.custId = UUID.randomUUID().toString().replace("-","");
    }
}
