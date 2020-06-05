package com.example.dto;

import lombok.Data;

@Data
public class RecordInfo {

    /**
     * 客户问题
     * {第一句为_first_|开头的开始标识，}
     */
    private String question;

    /**
     * 机器话术
     */
    private String answer;

    /**
     * 客户录音切片
     */
    private String audio_slice_id;

    /**
     * 是否打断
     * 1表示会话被打断
     */
    private String is_breakTts;
}
