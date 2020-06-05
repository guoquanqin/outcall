package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.config.OutCallConfig;
import com.example.dto.JsonDataDTO;
import com.example.dto.ParameterDTO;
import com.example.dto.TimeRangeDTO;
import com.example.dto.UserData;
import com.example.enums.EnumOutCallUrl;
import com.example.util.HttpUtil;
import com.example.util.MD5;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {

/*    @Autowired
    private OutCallConfig outCallConfig;*/
    /**
     * @Description: 外呼名单导入
     * @Author: QQ
     * @Date: 2020/6/3
     */
    @Test
    void test1() {
        String url = "http://47.92.225.212:6002/index.php/CommonTask/" + EnumOutCallUrl.UPLOADCALLDATA.getUri();
        ParameterDTO param = new ParameterDTO();
        param.setEnterpriseID("2019090921");
        param.initRequestId();
        param.setAddType("2");
        param.setTaskName("外呼任务");
        param.setTaskDesc("测试外呼呼叫名单");
        param.initToken(); //获取token
        param.setCoverType(1);
        List<JsonDataDTO> list = new ArrayList<>();
        UserData userData = new UserData();
        JsonDataDTO jsonDataDTO = new JsonDataDTO();

        userData.setAddress("健康路阳光大道888号");
        userData.setMoney("1213");
        jsonDataDTO.initCustId();
        jsonDataDTO.setUsername("张三");
        jsonDataDTO.setPhoneNum1("15100000000");
        jsonDataDTO.setPhoneNum2("15100000001");
        jsonDataDTO.setPhoneNum3("15100000002");
        jsonDataDTO.setPhoneNum4("15100000003");
        jsonDataDTO.setPhoneNum5("15100000004");
        jsonDataDTO.setUserData(userData);

        list.add(jsonDataDTO);
        param.setJsonData(list);
        String params = JSONObject.toJSON(param).toString();
        String result = HttpUtil.sendPost(url, params);
        System.out.println(result);
    }

    /**
     * @Description: 开始呼叫
     * @Author: QQ
     * @Date: 2020/6/3
     */
    @Test
    void test2(){
        String url = "http://47.92.225.212:6002/index.php/CommonTask/startCall";
        ParameterDTO param = new ParameterDTO();
        param.setEnterpriseID("2019090921");
        param.setRequestId("1000001");
        List<TimeRangeDTO> list = new ArrayList<>();
        TimeRangeDTO timeRangeDTO = new TimeRangeDTO();
        timeRangeDTO.setEndTime("2020-06-04 18:00:00");
        timeRangeDTO.setStartTime("2020-06-04 24:00:00");
        list.add(timeRangeDTO);
        param.setTimeRange(list);
        param.setCaller("0102265555");
        param.setCallType(1);
        param.setRepeatTimes(3);
        param.setProcessId(5);
        param.setSpanSec(120);
        param.initToken();
        String params = JSONObject.toJSON(param).toString();
        String result = HttpUtil.sendPost(url, params);
        System.out.println(result);
    }

    /**
     * @Description: 查询呼叫结果
     * @Author: QQ
     * @Date: 2020/6/3
     */
    @Test
    void test3(){
        String url = "http://47.92.225.212:6002/index.php/CommonTask/getTaskDetail";
        ParameterDTO param = new ParameterDTO();
        param.setEnterpriseID("20181229083554");
        param.setRequestId("2018122908355413300000009");
        param.setPage(1);
        param.setPageSize(20);
        param.setToken("7mfp0p3vuqff7j6fuabg55ut8u");
        String params = JSONObject.toJSON(param).toString();
        String result = HttpUtil.sendPost(url, params);
        System.out.println(result);
    }

    /**
     * @Description: 查询呼叫结果
     * @Author: QQ
     * @Date: 2020/6/3
     */
    @Test
    void test4(){
        String url = "http://47.92.225.212:6002/index.php/CommonTask/changeTaskStatus";
        ParameterDTO param = new ParameterDTO();
        param.setEnterpriseID("20181229083554");
        param.setRequestId("2018122908355413300000009");
        param.setStatus(0);
        param.setToken("7mfp0p3vuqff7j6fuabg55ut8u");
        String params = JSONObject.toJSON(param).toString();
        String result = HttpUtil.sendPost(url, params);
        System.out.println(result);
    }

    @Test
    public void test5(){
        StringBuffer Md5Token = new StringBuffer();
        Md5Token.append("2019090921");
        //当前时间，格式为20200601
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String now = sf.format(new Date());
        Md5Token.append(now);
        //随机生成盐值
        String salt = UUID.randomUUID().toString();
        Md5Token.append(salt);
        System.out.println(MD5.encode(Md5Token.toString()).toUpperCase());
    }



}
