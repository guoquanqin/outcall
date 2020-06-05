package com.example.dto;

import com.example.util.MD5;
import lombok.Data;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class ParameterDTO {

    /**
     * 用户所属企业 ID
     */
    private String enterpriseID;

    /**
     * 呼叫批次号
     */
    private String requestId;
    /**
     * 添加类型
     * 1=file=上传文件；2=json=上传json数据
     */
    private String addType;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 呼叫任务描述
     */
    private String taskDesc;

    /**
     * 上传的二进制文件
     * addType=1时 必填，格式见附录2
     */
    private File uploadFile;
    /**
     * 请求令牌
     * Md5(企业id+20190708(当前时间年月日)+盐值)
     * 生成字符串后全部转成大写
     */
    private String token;
    /**
     * 覆盖类型
     * coverType =1 覆盖数据，0追加数据
     * 默认coverType= 1覆盖数据
     */
    private Integer coverType;
    /**
     * 外显账号
     * 系统分配的外显账号，多个账号用英文逗号隔开
     */
    private String caller;
    /**
     * 重复次数
     * 重复拨打次数，默认一次
     */
    private Integer repeatTimes;
    /**
     * 间隔时间
     * 呼叫间隔时间，单位秒
     */
    private Integer spanSec;
    /**
     * 场景id
     * 业务场景ID，从外呼管理系统-》系统设置-》呼叫场景管理 中里面获取
     */
    private Integer businessSendcId;
    /**
     * 流程id
     * 关联呼叫流程的id，页面流程管理中获取
     */
    private Integer processId;
    /**
     * 呼叫类型
     */
    private Integer callType;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 任务状态
     * 0 初始态
     * 1呼叫结束
     * 4呼叫暂停
     * -1 删除任务
     * 7 停止（禁止删除外任何操作）
     */
    private Integer status;



    /**
     * 上传数据
     * addType=2时 必填 最大数量一次传输不超过2000个
     */
    private List<JsonDataDTO> jsonData;

    /**
     * 设置多个呼叫时间段
     */
    private List<TimeRangeDTO> timeRange;

    public void initToken() {
        StringBuffer md5Token = new StringBuffer();
        md5Token.append(this.getEnterpriseID());
        //当前时间，格式为20200601
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String now = sf.format(new Date());
        md5Token.append(now);
        //随机生成盐值
        //String salt = UUID.randomUUID().toString();
        String salt = "d24fe0dfcaeef24695fa0e6c367de969";
        md5Token.append(salt);

        //MD5加密
        this.token = MD5.encode(md5Token.toString()).toUpperCase();
    }

    /**
     * 初始化呼叫批次号
     */
    public void initRequestId(){
        this.requestId = UUID.randomUUID().toString().replace("-","");
    }

}
