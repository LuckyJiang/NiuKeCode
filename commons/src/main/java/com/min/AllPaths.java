package com.min;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * @author jxm
 * @version 1.0
 * @date 2021/4/1 16:53
 */
public class AllPaths {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * 获取当前类所在的工程路径，以下两种方法皆可：
         */
        //方法1：
        // Idea运行结果：类所在的工程路径E:\Projects\GIT\SimPSO\SimPSOServer
        //jar包路径：C:\Users\pc-fl\Desktop\SimPSO\案例demo\server\server5
        String path3 = System.getProperty("user.dir");
        System.out.println("类所在的工程路径" + path3);


        /**
         * 获取项目class路径方法
         */

        //1 使用类加载器路径:
        // IDea运行结果：class路径：/E:/Projects/GIT/SimPSO/SimPSOServer/target/classes/
        //jar包路径：C:\Users\pc-fl\Desktop\SimPSO\案例demo\server\server5
        String locationPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println("class路径：" + locationPath);

        //2 使用资源路径:
        // IDea运行结果：class路径：/E:/Projects/GIT/SimPSO/SimPSOServer/target/classes/
        //jar包路径：C:\Users\pc-fl\Desktop\SimPSO\案例demo\server\server5
        String locationPath1 = ResourceUtils.getURL("classpath:").getPath();
        System.out.println("class路径：" + locationPath1);
    }
}
