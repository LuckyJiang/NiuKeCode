package com.min.fastjson;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/4/13 11:25
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 总结了所有json转换的jar包： https://www.jb51.net/article/157516.htm
 *
 * fastjson:的使用总结：https://www.cnblogs.com/qqfff/p/12795820.html
 */
public class MyFastJson {
    public static void main(String[] args) {
        //创建测试object
        User user = new User("李宁",24,"北京");
        System.out.println(user);
        //转成json字符串
        String json = JSON.toJSON(user).toString();
        System.out.println(json);
        //json字符串转成对象
        User user1 = JSON.parseObject(json,User.class);
        System.out.println(user1);

        // 1、Json互转List<T>:
        jsonToList();

        // 2、对象与字符串互转
        objToString();
    }

    /**
     * 1、Json互转List<T>: 比如说List<Strudent>
     *                 List转Json
     */
    private static void jsonToList() {
        List<User> userList = new ArrayList();
        String str = JSON.toJSONString(userList); // List转json
        // Json 转List 方法一
        String json1 = ""; //获取的Json数据
        List<User> students = JSON.parseObject(json1,new TypeReference<List<User>>(){}); // Json 转List
        // Json 转List方法二（ 一般用方法二）

        List<User> users = JSON.parseArray(json1,User.class);
    }

    /**
     *2、对象与字符串互转
     */
    public static void objToString(){
        User user = new User("李宁",24,"北京");
        // 将对象转换成为字符串
        String str = JSON.toJSONString(user);
        // 字符串转换成为对象
        User user1 = JSON.parseObject(str, User.class);
    }

    /**
     * 3、字符串互转JSONObject
     */
    public static void stringToJsonObjt(){
        // String 转 Json对象
        JSONObject jsonObject = JSONObject.parseObject("");

        // json对象转string
        String jsonString = jsonObject.toJSONString();
    }

    /**
     * 4、map与字符串之间互转
     */
    public static void mapToString(){
        //字符串转map
        JSONObject  jsonObject = JSONObject.parseObject("");
        Map<String,Object> map = (Map<String,Object>)jsonObject;//    //json对象转Map
        //map转字符串
        String jsonString = JSON.toJSONString(map);
    }

    /**
     * 5、Map 转 Json对象
     */

    public static void mapToJson(){
        //map转json对象
        Map<String,Object> map = new HashMap<>();
        map.put("age", 24);
        map.put("name", "cool_summer_moon");
        JSONObject json = new JSONObject(map);
        //json对象转Map
        Map<String,Object> map1 = (Map<String,Object>)json;
    }
}