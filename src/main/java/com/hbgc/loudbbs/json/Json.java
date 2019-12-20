package com.hbgc.loudbbs.json;

import java.util.HashMap;
import java.util.Map;

public class Json {

    //默认成功响应
    public static Map<String, Object> success(Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("msg", "ok");
        map.put("data", data);
        return map;
    }

    //自定义消息的成功响应
    public static Map<String, Object> success(Object data,String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> success(Object data,String msg,String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("msg", msg);
        map.put("data", data);
        map.put("token",token);
        return map;
    }



    //自定义消息的失败响应
    public static Map<String, Object> fail(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 400);
        map.put("msg", msg); // Json.fail("验证码不正确"); Json.fail("用户名和密码");
        return map;
    }

    //默认失败响应
    public static Map<String, Object> fail() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 400);
        map.put("msg", "error");
        return map;
    }

    public static Map<String, Object> imgsuccess(Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("errno", 0);
        map.put("data", data);
        return map;
    }
}