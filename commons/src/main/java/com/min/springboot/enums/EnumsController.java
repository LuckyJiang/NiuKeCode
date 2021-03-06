package com.min.springboot.enums;

import com.min.springboot.enums.常量接口;
import com.min.springboot.enums.常量类;
import com.min.springboot.enums.枚举常量;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jxm
 * @version 1.0
 * @date 2020/6/17 16:17
 */
@RestController
public class EnumsController {

    /**
     * 枚举详解
     * https://blog.csdn.net/javazejian/article/details/71333103
     * @return
     */
    @GetMapping("/enums")
    public List<String> list(){
        List<String> list = new ArrayList<>();
        list.add(Double.toString(常量接口.MATH_E));
        list.add(常量类.Success);
        list.add(枚举常量.XINGQI_YI.getCode() + 枚举常量.XINGQI_YI.getMassage());
        return list;
    }
}
